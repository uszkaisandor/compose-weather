package com.uszkaisandor.weathercompose.data.dto

import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("dt")
    val timeStamp: Long,
    val sunrise: Long,
    val sunset: Long,
    val temp: Float?,
    val pressure: Int,
    val humidity: Int,
    @SerializedName("uvi")
    val uvIndex: Float,
    @SerializedName("wind_speed")
    val windSpeed: Float,
    @SerializedName("wind_deg")
    val windDegree: Int,
    @SerializedName("feels_like")
    val feelsLike: Float?,
    val weather: List<WeatherDescriptor>,
    val snow: Snow? = null,
)