package com.uszkaisandor.weathercompose.features.weather_forecast

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uszkaisandor.weathercompose.data.dto.DailyWeatherDto

@Composable
fun DailyForecast(weatherList: List<DailyWeatherDto>?) {
    weatherList?.let {
        LazyColumn(modifier = Modifier.padding(top = 12.dp)) {
            items(it) { weather ->
                DailyForecastItem(weather = weather)
            }
        }
    }
}