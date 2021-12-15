package com.uszkaisandor.weathercompose.data.dto

import com.google.gson.annotations.SerializedName

data class TemperatureDto(
    val temp: Float,
    @SerializedName("feels_like")
    val feelsLike: Float,
    @SerializedName("temp_min")
    val tempMin: Float,
    @SerializedName("temp_max")
    val tempMax: Float,
    val pressure: Float,
    val humidity: Float
)