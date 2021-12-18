package com.uszkaisandor.weathercompose.data.dto

import com.google.gson.annotations.SerializedName

data class Snow(
    @SerializedName("1h")
    val unitsPerHour: Float
)