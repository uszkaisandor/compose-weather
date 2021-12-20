package com.uszkaisandor.weathercompose.data.dto

import com.google.gson.annotations.SerializedName

data class DailyWeatherDto(
    @SerializedName("dt")
    val timestamp: Long,
    val sunrise: Long,
    val sunset: Long,
    val moonrise: Long,
    val moonset: Long,
    val temp: DailyTemperatureDto,
    val feels_like: DailyTemperatureDto,
    val pressure: Float,
    val humidity: Float,
    val dew_point: Float,
    val wind_speed: Float,
    val wind_deg: Float,
    val weather: List<WeatherDescriptor>,
    val clouds: Float,
    val pop: Float,
    val rain: Float,
    val snow: Float,
    val uvi: Float
)