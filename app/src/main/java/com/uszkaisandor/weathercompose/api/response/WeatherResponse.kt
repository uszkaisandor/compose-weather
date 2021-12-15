package com.uszkaisandor.weathercompose.api.response

import com.uszkaisandor.weathercompose.data.dto.TemperatureDto
import com.uszkaisandor.weathercompose.data.dto.WeatherDto

data class WeatherResponse(
    val weather: List<WeatherDto>,
    val main: TemperatureDto,
    val name: String
)