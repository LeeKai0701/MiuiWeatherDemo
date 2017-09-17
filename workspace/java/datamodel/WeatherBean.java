package datamodel;

/**
 * Created by likai on 2017/9/16.
 * 这个类就是一个天气的数据类
 */
public class WeatherBean {

    //-----常量-----//
    public static final String QING    = "晴";
    public static final String YU      = "雨";
    public static final String LEI     = "雷";
    public static final String DUOYUN  = "多云";
    public static final String YIN     = "阴";
    public static final String XUE     = "雪";

    //-----成员变量-----//
    private int mTemperature; //实际的温度值
    private String mTempeDes; //显示的温度文本
    private String mTime;
    private String mWeather; //上面定义的6种之一

    /**
     *
     * @param temperature 温度值
     * @param time 时间
     * @param weather 天气
     */
    public WeatherBean(int temperature, String time, String weather) {
        mTemperature = temperature;
        mTime = time;
        mWeather = weather;
        mTempeDes = temperature + "°";
    }

    /**
     *
     * @param temperature 温度值
     * @param tempDes 替代温度值显示的文本，如果定义了，则会替代温度的显示
     * @param time 时间
     * @param weather 天气
     */
    public WeatherBean(int temperature, String tempDes, String time, String weather) {
        mTemperature = temperature;
        mTempeDes = tempDes;
        mTime = time;
        mWeather = weather;
    }

    public String[] getAllWeather() {
        String[] weathers = {QING, YU, LEI, DUOYUN, YIN, XUE};
        return weathers;
    }

}
