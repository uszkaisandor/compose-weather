package com.uszkaisandor.weathercompose.data.dto

data class DailyTemperatureDto(
    val day: Float,
    val min: Float?,
    val max: Float?,
    val night: Float,
    val eve: Float,
    val morn: Float
)