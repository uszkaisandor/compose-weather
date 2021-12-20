package com.uszkaisandor.weathercompose.features.hourly_forecast

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.uszkaisandor.weathercompose.data.dto.WeatherDto
import com.uszkaisandor.weathercompose.data.repository.WeatherRepository
import kotlin.math.roundToInt

@Composable
fun HourlyForecastCard(weather: WeatherDto) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            color = Color.White,
            style = MaterialTheme.typography.h5,
            text = "10:00",
            textAlign = TextAlign.Center
        )
        Image(
            painter = rememberImagePainter(
                data = "http://openweathermap.org/img/wn/${weather.weather[0].icon}@2x.png",
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .size(46.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            color = Color.White,
            style = MaterialTheme.typography.h4,
            text = "${weather.temp?.roundToInt()} °C",
        )
    }
}

@Preview
@Composable
fun HourlyForecastCardPreview(weather: WeatherDto = WeatherRepository.weather) {
    HourlyForecastCard(weather = weather)
}