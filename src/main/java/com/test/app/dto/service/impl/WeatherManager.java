package com.test.app.dto.service.impl;

import com.alibaba.fastjson.JSON;
import com.test.app.dto.WeatherDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import com.test.app.dto.service.IWeatherManager;
@Component
@Slf4j
public class WeatherManager implements IWeatherManager {
    //请求连接地址
    final static String SOJSON_WEATHER_URL = "http://t.weather.sojson.com/api/weather/city/{1}";

    /**
     * get data
     * @param id
     * @return
     */
    @Override
    @Cacheable(cacheNames = "weather_cache", key = "#id")// 从缓存获取，key为ID，缓存具体看 ehcache.xml 配置文件
    public String getWeatherById(String id) {
        log.info("WeatherManager#getById: id={}", id);

        try {
            RestTemplate restTemplate = new RestTemplate();
            WeatherDto dto = restTemplate.getForObject(SOJSON_WEATHER_URL , WeatherDto.class,id);
            List<Map> mapList = new ArrayList<>();


            if(dto != null && dto.isSuccess()){
                Map mapCity = new HashMap();
                mapCity.put("value1","City");
                mapCity.put("value2",dto.getCityInfo().getCity());
                mapList.add(mapCity);

                Map mapUpdataTime = new HashMap();
                mapUpdataTime.put("value1","Updated time");
                mapUpdataTime.put("value2",dto.getTime());
                mapList.add(mapUpdataTime);

                Map mapWeather = new HashMap();
                mapWeather.put("value1","Weather");
                mapWeather.put("value2",dto.getData().getForecast().get(0).getFl()+" " +dto.getData().getForecast().get(0).getFx());
                mapList.add(mapWeather);

                Map mapTemperature = new HashMap();
                mapTemperature.put("value1","Temperature");
                mapTemperature.put("value2",dto.getData().getWendu());
                mapList.add(mapTemperature);

                Map mapWind = new HashMap();
                mapWind.put("value1","Wind");
                mapWind.put("value2",dto.getData().getForecast().get(0).getFx());
                mapList.add(mapWind);
                String jsonString = JSON.toJSONString(mapList);
                return jsonString;
            }else{
                log.error("获取天气数据返回错误：{}", dto);
            }
        } catch (RestClientException e) {
            log.error("获取天气数据返回错误，出现异常.", e);
        }
        return null;
    }
    /**
     * get all cities
     * @return
     */
    @Override
    public String getCities(String cities) {
        List<String> cityList = Arrays.asList(cities.split(","));
        List<Map>  mapList = new ArrayList<>();
        for (int i=0; i< cityList.size(); i++) {
            List<String> cityCodes = Arrays.asList(cityList.get(i).split(":"));
            Map map = new HashMap();
            map.put("value",cityCodes.get(0));
            map.put("label",cityCodes.get(1));
            mapList.add(map);
        }
        String jsonString = JSON.toJSONString(mapList);
        return jsonString;
    }

}
