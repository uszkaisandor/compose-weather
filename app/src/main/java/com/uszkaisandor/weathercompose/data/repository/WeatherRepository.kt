package com.uszkaisandor.weathercompose.data.repository

import com.uszkaisandor.weathercompose.api.WeatherApi
import com.uszkaisandor.weathercompose.api.response.WeatherResponse
import com.uszkaisandor.weathercompose.data.dto.ExcludeData
import javax.inject.Inject

class WeatherRepository
@Inject
constructor(
    private val weatherApi: WeatherApi
) {

    suspend fun getWeatherByCity(
        latitude: Float,
        longitude: Float,
        unit: String,
        apiKey: String,
        language: String
    ): WeatherResponse {
        return weatherApi.getCurrentWeatherByCity(
            latitude = latitude,
            longitude = longitude,
            excludeData = ExcludeData.MINUTELY,
            unit = unit,
            language = language,
            apiKey = apiKey
        )
    }

}