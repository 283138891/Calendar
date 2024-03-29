package com.example.calendar;

import java.util.List;

public class JsonBean {


    /**
     * reason : 查询成功!
     * result : {"city":"成都","realtime":{"temperature":"24","humidity":"65","info":"阴","wid":"02","direct":"东北风","power":"1级","aqi":"33"},"future":[{"date":"2019-06-23","temperature":"20/29℃","weather":"多云转阵雨","wid":{"day":"01","night":"03"},"direct":"持续无风向"},{"date":"2019-06-24","temperature":"20/26℃","weather":"阵雨转晴","wid":{"day":"03","night":"00"},"direct":"持续无风向"},{"date":"2019-06-25","temperature":"21/27℃","weather":"阵雨转晴","wid":{"day":"03","night":"00"},"direct":"持续无风向"},{"date":"2019-06-26","temperature":"21/29℃","weather":"阵雨转小雨","wid":{"day":"03","night":"07"},"direct":"持续无风向"},{"date":"2019-06-27","temperature":"20/26℃","weather":"小雨","wid":{"day":"07","night":"07"},"direct":"持续无风向"}]}
     * error_code : 0
     */

    private ResultBean result;

    public ResultBean getResult() {
        return result;
    }

    public void setResult( ResultBean result ) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * city : 成都
         * realtime : {"temperature":"24","humidity":"65","info":"阴","wid":"02","direct":"东北风","power":"1级","aqi":"33"}
         * future : [{"date":"2019-06-23","temperature":"20/29℃","weather":"多云转阵雨","wid":{"day":"01","night":"03"},"direct":"持续无风向"},{"date":"2019-06-24","temperature":"20/26℃","weather":"阵雨转晴","wid":{"day":"03","night":"00"},"direct":"持续无风向"},{"date":"2019-06-25","temperature":"21/27℃","weather":"阵雨转晴","wid":{"day":"03","night":"00"},"direct":"持续无风向"},{"date":"2019-06-26","temperature":"21/29℃","weather":"阵雨转小雨","wid":{"day":"03","night":"07"},"direct":"持续无风向"},{"date":"2019-06-27","temperature":"20/26℃","weather":"小雨","wid":{"day":"07","night":"07"},"direct":"持续无风向"}]
         */

        private String city;
        private RealtimeBean realtime;
        private List<FutureBean> future;

        public String getCity() {
            return city;
        }

        public void setCity( String city ) {
            this.city = city;
        }

        public RealtimeBean getRealtime() {
            return realtime;
        }

        public void setRealtime( RealtimeBean realtime ) {
            this.realtime = realtime;
        }

        public List<FutureBean> getFuture() {
            return future;
        }

        public void setFuture( List<FutureBean> future ) {
            this.future = future;
        }

        public static class RealtimeBean {
            /**
             * temperature : 24
             * humidity : 65
             * info : 阴
             * wid : 02
             * direct : 东北风
             * power : 1级
             * aqi : 33
             */

            private String temperature;
            private String humidity;
            private String info;
            private String wid;
            private String direct;
            private String power;
            private String aqi;
            public String getTemperature() {
                return temperature;
            }

            public void setTemperature( String temperature ) {
                this.temperature = temperature;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity( String humidity ) {
                this.humidity = humidity;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo( String info ) {
                this.info = info;
            }

            public String getWid() {
                return wid;
            }

            public void setWid( String wid ) {
                this.wid = wid;
            }

            public String getDirect() {
                return direct;
            }

            public void setDirect( String direct ) {
                this.direct = direct;
            }

            public String getPower() {
                return power;
            }

            public void setPower( String power ) {
                this.power = power;
            }

            public String getAqi() {
                return aqi;
            }

            public void setAqi( String aqi ) {
                this.aqi = aqi;
            }
        }

        public static class FutureBean {
            /**
             * date : 2019-06-23
             * temperature : 20/29℃
             * weather : 多云转阵雨
             * wid : {"day":"01","night":"03"}
             * direct : 持续无风向
             */

            private String date;
            private String temperature;
            private String weather;
            private WidBean wid;
            private String direct;

            public String getDate() {
                return date;
            }

            public void setDate( String date ) {
                this.date = date;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature( String temperature ) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather( String weather ) {
                this.weather = weather;
            }

            public WidBean getWid() {
                return wid;
            }

            public void setWid( WidBean wid ) {
                this.wid = wid;
            }

            public String getDirect() {
                return direct;
            }

            public void setDirect( String direct ) {
                this.direct = direct;
            }

            public static class WidBean {
                /**
                 * day : 01
                 * night : 03
                 */

                private String day;
                private String night;

                public String getDay() {
                    return day;
                }

                public void setDay( String day ) {
                    this.day = day;
                }

                public String getNight() {
                    return night;
                }

                public void setNight( String night ) {
                    this.night = night;
                }
            }
        }
    }
}
