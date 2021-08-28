package com.example.weatherapp;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity2 {

    private String mTemperature,mcity,mWeatherType,mpressure,mhumidity;
    private int mCondition;

    public static MainActivity2 fromJson(JSONObject jsonObject)
    {

        try
        {
            MainActivity2 weatherD=new MainActivity2();
            weatherD.mcity=jsonObject.getString("name");
            weatherD.mCondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            double tempResult=jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue=(int)Math.rint(tempResult);
            weatherD.mTemperature=Integer.toString(roundedValue);
            return weatherD;
        }


        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }




    public String getmTemperature() {
        return mTemperature+"°C";
    }


    public String getMcity() {
        return mcity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }
}