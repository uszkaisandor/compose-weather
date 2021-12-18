package com.uszkaisandor.weathercompose.api

import com.uszkaisandor.weathercompose.BuildConfig
import com.uszkaisandor.weathercompose.api.response.WeatherResponse
import com.uszkaisandor.weathercompose.data.dto.ExcludeData
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    companion object {
        //const val ACCESS_KEY = BuildConfig.WEATHER_API_KEY
    }

    @GET("data/2.5/onecall")
    suspend fun getCurrentWeatherByCity(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("exclude") excludeData: ExcludeData,
        @Query("units") unit: String,
        @Query("lang") language: String,
        @Query("appid") apiKey: String,
        ): WeatherResponse

}