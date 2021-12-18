package com.uszkaisandor.weathercompose.data.dto

import com.google.gson.annotations.SerializedName

enum class ExcludeData {
    @SerializedName("hourly")
    HOURLY,

    @SerializedName("minutely")
    MINUTELY,

    @SerializedName("daily")
    DAILY
}
