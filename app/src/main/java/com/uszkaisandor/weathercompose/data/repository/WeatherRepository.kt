package com.uszkaisandor.weathercompose.data.repository

import com.uszkaisandor.weathercompose.BuildConfig
import com.uszkaisandor.weathercompose.api.WeatherApi
import com.uszkaisandor.weathercompose.api.response.WeatherResponse
import javax.inject.Inject

class WeatherRepository
@Inject
constructor(
    private val weatherApi: WeatherApi
) {

    suspend fun getWeatherByCity(unit: String, city: String, apiKey: String): WeatherResponse {
        return weatherApi.getCurrentWeatherByCity(unit, city, apiKey)
    }

}