package com.uszkaisandor.weathercompose.api.response

import com.uszkaisandor.weathercompose.data.dto.DailyWeatherDto
import com.uszkaisandor.weathercompose.data.dto.WeatherDto

data class WeatherResponse(
    val current: WeatherDto,
    val hourly: List<WeatherDto>,
    val daily: List<DailyWeatherDto>
)