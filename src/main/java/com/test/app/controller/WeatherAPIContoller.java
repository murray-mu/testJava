package com.test.app.controller;
import com.test.app.dto.service.impl.WeatherManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("api")
public class WeatherAPIContoller {

    @Autowired
    WeatherManager weatherManager;
    @Value("${city.code}")
    private String cityCode;
    /**
     * get data
     * @param id
     * @return
     */
    @RequestMapping(value = "city/{id:1[0-9]{8}}", method = RequestMethod.GET)
    public String getWeatherById(@PathVariable("id") String id){
        if(!cityCode.contains(id)){
            throw new RuntimeException("no_city_id");
        }
        return weatherManager.getWeatherById(id);
    }
    /**
     * get all cities
     * @return
     */
    @RequestMapping(value = "cities", method = RequestMethod.GET)
    public String getCities(){
        return weatherManager.getCities(cityCode);
    }
}
