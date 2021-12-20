package com.uszkaisandor.weathercompose.features.weather_forecast

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.uszkaisandor.weathercompose.data.dto.DailyWeatherDto

@Composable
fun DailyForecast(weatherList: List<DailyWeatherDto>?) {
    weatherList?.let {
        LazyColumn() {
            items(it) { weather ->
                DailyForecastItem(weather = weather)
            }
        }
    }
}