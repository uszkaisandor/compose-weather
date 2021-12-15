package com.uszkaisandor.weathercompose.api

import com.uszkaisandor.weathercompose.BuildConfig
import com.uszkaisandor.weathercompose.api.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    companion object {
        //const val ACCESS_KEY = BuildConfig.WEATHER_API_KEY
    }

    @GET("data/2.5/weather")
    suspend fun getCurrentWeatherByCity(
        @Query("units") unit: String,
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): WeatherResponse

}