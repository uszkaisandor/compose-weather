package com.uszkaisandor.weathercompose.features.current_weather.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.uszkaisandor.weathercompose.data.dto.WeatherDto
import com.uszkaisandor.weathercompose.data.repository.WeatherRepository
import kotlin.math.roundToInt

@Composable
fun CurrentWeather(weather: WeatherDto?) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colors.primaryVariant,
                        MaterialTheme.colors.primary
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(
                    data = "http://openweathermap.org/img/wn/${weather?.weather?.firstOrNull()?.icon}@2x.png",
                    builder = {
                        crossfade(true)
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(130.dp)
            )
            val textModifier = Modifier.align(Alignment.CenterHorizontally)
            Text(
                // todo refactor it later
                text = "${weather?.temp?.roundToInt()} °C",
                style = MaterialTheme.typography.h2,
                modifier = textModifier,
                color = MaterialTheme.colors.onPrimary
            )
            Text(
                text = weather?.weather?.firstOrNull()?.description ?: "",
                textModifier.padding(top = 12.dp, bottom = 12.dp),
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(
    weather: WeatherDto = WeatherRepository.weather
) {
    CurrentWeather(weather = weather)
}