package com.test.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@lombok.Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherDto implements Serializable {

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CityInfo getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
    }

    public WeatherData getData() {
        return data;
    }

    public void setData(WeatherData data) {
        this.data = data;
    }

    public List<Xianhao> getXianhao() {
        return xianhao;
    }

    public void setXianhao(List<Xianhao> xianhao) {
        this.xianhao = xianhao;
    }

    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status;
    //第一天时间
    private String date;
    private String time;
    //当前主题信息
    private CityInfo cityInfo;

    private WeatherData data;


    public boolean isSuccess(){
        return this.status == 200;
    }
    /**
     * 当前城市信息
     */
    @lombok.Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class CityInfo implements Serializable {
        //城市name 如 茶陵
        private String city;

        public String getCitykey() {
            return citykey;
        }

        public void setCitykey(String citykey) {
            this.citykey = citykey;
        }

        //城市id
        private String citykey;
        //父级城市，比如市级，省级
        private String parent;
        //更新时间
        private String updateTime;


        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }
    //限号的城市
    private List<Xianhao> xianhao = new ArrayList<>();
    @lombok.Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Xianhao  implements Serializable {
        private String date;//日期
        private String number;//限制的车牌号码3,8

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        private String cityId;//城市ID
        private String title;//标题 ：限制

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    ///////////////////////////  天气主体信息 ///////////////////////////////////
    @lombok.Data
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class WeatherData  implements Serializable {

        //兼容字段
        private String shidu;

        public Double getPm25() {
            return pm25;
        }

        public void setPm25(Double pm25) {
            this.pm25 = pm25;
        }

        private Double pm25;
        private Double pm10;
        private String quality;
        private String wendu;
        private String ganmao;


        //空气质量
        private AirQuality air;
        //当天天气其他说明
        private Expand expand;

        //各种指数
        private List<Index> indexes = new ArrayList<>();

        //15天天气预报
        //限号的城市

        private List<Forecast> forecast = new ArrayList<>();


        //昨天，从forecast取一条放到 yesterday
        private Forecast yesterday;

        //24小时天气
        private List<Hour> hour24 = new ArrayList<>();

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public Double getPm10() {
            return pm10;
        }

        public void setPm10(Double pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public AirQuality getAir() {
            return air;
        }

        public void setAir(AirQuality air) {
            this.air = air;
        }

        public Expand getExpand() {
            return expand;
        }

        public void setExpand(Expand expand) {
            this.expand = expand;
        }

        public List<Index> getIndexes() {
            return indexes;
        }

        public void setIndexes(List<Index> indexes) {
            this.indexes = indexes;
        }

        public List<Forecast> getForecast() {
            return forecast;
        }

        public void setForecast(List<Forecast> forecast) {
            this.forecast = forecast;
        }

        public Forecast getYesterday() {
            return yesterday;
        }

        public void setYesterday(Forecast yesterday) {
            this.yesterday = yesterday;
        }

        public List<Hour> getHour24() {
            return hour24;
        }

        public void setHour24(List<Hour> hour24) {
            this.hour24 = hour24;
        }


        //空气质量相关evn
        @lombok.Data
        public static class AirQuality  implements Serializable {
            private String no2;
            private String mp;
            private String pm25;
            private String o3;

            public String getSo2() {
                return so2;
            }

            public void setSo2(String so2) {
                this.so2 = so2;
            }

            private String so2;
            private String aqi;
            private String pm10;
            private String suggest;//如：各类人群可自由活动",
            private String time;//更新时间":"22:00:00",
            private String co;
            private String quality;//":"优"

            public String getNo2() {
                return no2;
            }

            public void setNo2(String no2) {
                this.no2 = no2;
            }

            public String getMp() {
                return mp;
            }

            public void setMp(String mp) {
                this.mp = mp;
            }

            public String getPm25() {
                return pm25;
            }

            public void setPm25(String pm25) {
                this.pm25 = pm25;
            }

            public String getO3() {
                return o3;
            }

            public void setO3(String o3) {
                this.o3 = o3;
            }

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public String getPm10() {
                return pm10;
            }

            public void setPm10(String pm10) {
                this.pm10 = pm10;
            }

            public String getSuggest() {
                return suggest;
            }

            public void setSuggest(String suggest) {
                this.suggest = suggest;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getCo() {
                return co;
            }

            public void setCo(String co) {
                this.co = co;
            }

            public String getQuality() {
                return quality;
            }

            public void setQuality(String quality) {
                this.quality = quality;
            }
        }


        /**
         * 当天天气拓展
         */
        @lombok.Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class Expand  implements Serializable {
            /**
             * 湿度
             */
            private String humidity;
            /**
             * 天气
             */
            private String weather;
            //天气类型  如：2
            private Integer weatherType;

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            //更新时间
            private String updateTime;
            //体感温度
            private String stemp;
            //风速
            private String windPower;
            //风向
            private String windDirection;

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public Integer getWeatherType() {
                return weatherType;
            }

            public void setWeatherType(Integer weatherType) {
                this.weatherType = weatherType;
            }

            public String getStemp() {
                return stemp;
            }

            public void setStemp(String stemp) {
                this.stemp = stemp;
            }

            public String getWindPower() {
                return windPower;
            }

            public void setWindPower(String windPower) {
                this.windPower = windPower;
            }

            public String getWindDirection() {
                return windDirection;
            }

            public void setWindDirection(String windDirection) {
                this.windDirection = windDirection;
            }
        }




        /**
         * 小时天气
         */
        @lombok.Data
        public static class Hour  implements Serializable {
            /**
             * 温度
             */
            private Integer temperature;

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            /**
             * 湿度
             */
            private String humidity;
            //风速
            private String windPower;
            //风向
            private String windDirection;
            private String weather;
            //天气类型  如：2
            private Integer weatherType;
            //时间 如：201708241900
            private String time;


            public Integer getTemperature() {
                return temperature;
            }

            public void setTemperature(Integer temperature) {
                this.temperature = temperature;
            }

            public String getWindPower() {
                return windPower;
            }

            public void setWindPower(String windPower) {
                this.windPower = windPower;
            }

            public String getWindDirection() {
                return windDirection;
            }

            public void setWindDirection(String windDirection) {
                this.windDirection = windDirection;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public Integer getWeatherType() {
                return weatherType;
            }

            public void setWeatherType(Integer weatherType) {
                this.weatherType = weatherType;
            }

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }
        }


        /**
         * 天气预报，一天
         */
        @lombok.Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class Forecast implements Serializable {

            //日期
            private String date;
            //最高温度，最低温度
            private String high;

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            private String low;
            private String ymd;
            private String week;
            //日出 & 日落
            private String sunrise;
            private String sunset;
            //空气质量
            private Integer aqi;
            //白天天气
            private Day day;
            //晚上天气
            private Day night;



            //兼容字段
            //风向
            private String fx;
            //风力
            private String fl;
            //天气类型
            private String type;
            private String notice;


            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getYmd() {
                return ymd;
            }

            public void setYmd(String ymd) {
                this.ymd = ymd;
            }

            public String getWeek() {
                return week;
            }

            public void setWeek(String week) {
                this.week = week;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public Integer getAqi() {
                return aqi;
            }

            public void setAqi(Integer aqi) {
                this.aqi = aqi;
            }

            public Day getDay() {
                return day;
            }

            public void setDay(Day day) {
                this.day = day;
            }

            public Day getNight() {
                return night;
            }

            public void setNight(Day night) {
                this.night = night;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }

        //白天 & 晚上 天气描述
        @lombok.Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class Day implements Serializable {
            //风速
            private String windPower;
            //风向
            private String windDirection;

            public String getWindPower() {
                return windPower;
            }

            public void setWindPower(String windPower) {
                this.windPower = windPower;
            }

            //公告    如："悠悠的云里有淡淡的诗"
            private String notice;
            //天气描述  如：多云
            private String weather;


            public String getWindDirection() {
                return windDirection;
            }

            public void setWindDirection(String windDirection) {
                this.windDirection = windDirection;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }
        }





        /**
         * 各种指数
         */
        @lombok.Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class Index  implements Serializable {
            //指数图标
            private String icon;
            //指数值          如：较适宜
            private String value;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            //指数名称
            private String name;
            //指数简单描述    如：较适宜晨练
            private String tips;
            //指数详细描述
            private String description;


            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getTips() {
                return tips;
            }

            public void setTips(String tips) {
                this.tips = tips;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }


    }




}


