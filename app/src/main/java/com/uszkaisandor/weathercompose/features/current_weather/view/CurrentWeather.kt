package com.uszkaisandor.weathercompose.features.current_weather.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.uszkaisandor.weathercompose.data.dto.WeatherDescriptor
import com.uszkaisandor.weathercompose.data.dto.WeatherDto
import kotlin.math.roundToInt

@Composable
fun CurrentWeather(weather: WeatherDto) {
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
            )
            val textModifier = Modifier.align(Alignment.CenterHorizontally)
            Text(
                // todo refactor it later
                text = "${weather.temp?.roundToInt()} °C",
                style = MaterialTheme.typography.h2,
                modifier = textModifier,
                color = Color.White
            )
            /*Text(
                text = weather.weather[0].main,
                modifier = textModifier.padding(top = 12.dp),
                color = Color.White
            )*/
            Text(
                text = weather.weather[0].description,
                textModifier.padding(top = 12.dp, bottom = 12.dp),
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(
    weather: WeatherDto = WeatherDto(
        timeStamp = 1640005200, sunrise = 0, 0, 23f, 789, 1001, 0.3f, 100f, 234, 25.6f,
        weather = listOf(
            WeatherDescriptor(
                id = 804,
                main = "Clouds",
                description = "overcast clouds",
                icon = "04n"
            )
        )
    )
) {
    CurrentWeather(weather = weather)
}