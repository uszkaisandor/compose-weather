package com.uszkaisandor.weathercompose.features.weather_forecast

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.uszkaisandor.weathercompose.data.dto.DailyWeatherDto
import org.threeten.bp.Instant
import org.threeten.bp.ZoneId
import org.threeten.bp.format.TextStyle
import kotlin.math.roundToInt

@Composable
fun DailyForecastItem(weather: DailyWeatherDto) {
    Surface(
        modifier = Modifier.background(color = MaterialTheme.colors.surface)
    ) {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.h3,
                text = getDayFromTimeStamp(weather.timestamp),
                textAlign = TextAlign.Center,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    modifier = Modifier.padding(end = 12.dp),
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.h3,
                    text = "${weather.temp.max?.roundToInt()} °C",
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
                )
            }
        }
    }
}

fun getDayFromTimeStamp(time: Long): String {
    return Instant.ofEpochSecond(time)
        .atZone(ZoneId.systemDefault())
        .dayOfWeek
        .getDisplayName(TextStyle.FULL, java.util.Locale.getDefault())
}

