package com.uszkaisandor.weathercompose.features.hourly_forecast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uszkaisandor.weathercompose.data.dto.WeatherDto

@Composable
fun HourlyForecast(weatherList: List<WeatherDto>?) {
    weatherList?.let {
        LazyRow(
            modifier = Modifier.background(color = MaterialTheme.colors.primary).padding(top = 8.dp, bottom = 8.dp),
        ) {
            items(it.subList(0, 24)) { weather ->
                HourlyForecastCard(weather = weather)
            }
        }
    }
}