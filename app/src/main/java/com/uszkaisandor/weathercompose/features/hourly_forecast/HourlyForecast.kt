package com.uszkaisandor.weathercompose.features.hourly_forecast

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.uszkaisandor.weathercompose.data.dto.WeatherDto

@Composable
fun HourlyForecast(weatherList: List<WeatherDto>?) {
    weatherList?.let {
        LazyRow() {
            items(it.subList(0,24)) { weather ->
                HourlyForecastCard(weather = weather)
            }
        }
    }
}