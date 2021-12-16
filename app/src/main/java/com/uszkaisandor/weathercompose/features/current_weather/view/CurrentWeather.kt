package com.uszkaisandor.weathercompose.features.current_weather.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.uszkaisandor.weathercompose.api.response.WeatherResponse
import kotlin.math.roundToInt

@Composable
fun CurrentWeather(weather: WeatherResponse) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(20.dp)
    ) {
        Image(
            painter = rememberImagePainter(
                data = "http://openweathermap.org/img/wn/${weather.weather[0].icon}@2x.png",
                builder = {
                    crossfade(true)
                }
            ),
            colorFilter = ColorFilter.tint(
                Color.White,
                BlendMode.SrcAtop
            ),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
        )
        val textModifier = Modifier.align(Alignment.CenterHorizontally)
        Text(
            // todo refactor it later
            text = "${weather.main.temp.roundToInt()} °C",
            style = MaterialTheme.typography.h2,
            modifier = textModifier,
            color = Color.White
        )
        Text(
            text = weather.name,
            modifier = textModifier.padding(top = 12.dp),
            color = Color.White
        )
        Text(
            text = weather.weather[0].description,
            textModifier.padding(top = 12.dp),
            color = Color.White
        )
    }
}