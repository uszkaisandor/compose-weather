package com.uszkaisandor.weathercompose.data.repository

import com.uszkaisandor.weathercompose.api.WeatherApi
import com.uszkaisandor.weathercompose.api.response.WeatherResponse
import com.uszkaisandor.weathercompose.data.dto.ExcludeData
import com.uszkaisandor.weathercompose.data.dto.WeatherDescriptor
import com.uszkaisandor.weathercompose.data.dto.WeatherDto
import javax.inject.Inject

class WeatherRepository
@Inject
constructor(
    private val weatherApi: WeatherApi
) {

    companion object {
        // todo remove this later
        val weather: WeatherDto = WeatherDto(
            timeStamp = 1640005200, sunrise = 0, 0, 23f, 789, 1001, 0.3f, 100f, 234, 25.6f,
            weather = listOf(
                WeatherDescriptor(
                    id = 804,
                    main = "Clouds",
                    description = "overcast clouds",
                    icon = "04n"
                )
            )
        )

        val hourlyWeatherList = arrayListOf(
            weather, weather, weather, weather, weather, weather,
            weather
        )

    }

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