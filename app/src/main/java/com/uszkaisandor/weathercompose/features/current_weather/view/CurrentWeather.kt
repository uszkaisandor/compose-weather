package com.uszkaisandor.weathercompose.features.current_weather.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.uszkaisandor.weathercompose.api.response.WeatherResponse
import kotlin.math.roundToInt

@Composable
fun CurrentWeather(weather: WeatherResponse) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()) {
        Image(
            painter = rememberImagePainter(
                data = "http://openweathermap.org/img/wn/${weather.weather[0].icon}@2x.png",
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
        )
        val textModifier = Modifier.align(Alignment.CenterHorizontally)
        Text(text = weather.name, modifier = textModifier)
        Text(text = weather.weather[0].description, modifier = textModifier)
        Text(text = weather.main.temp.roundToInt().toString(), modifier = textModifier)
    }
}