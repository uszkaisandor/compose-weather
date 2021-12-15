package com.uszkaisandor.weathercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uszkaisandor.weathercompose.api.response.WeatherResponse
import com.uszkaisandor.weathercompose.data.dto.TemperatureDto
import com.uszkaisandor.weathercompose.data.dto.WeatherDto
import com.uszkaisandor.weathercompose.features.current_weather.CurrentWeatherViewModel
import com.uszkaisandor.weathercompose.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.primary) {
                    WeatherScreen()
                }
            }
        }
    }
}

@Composable
fun WeatherScreen(viewModel: CurrentWeatherViewModel = viewModel()) {
    val weather = viewModel.weather.collectAsState().value
    Column {
        Text(text = weather?.name ?: "")
        Text(text = weather?.weather?.get(0)?.description ?: "")
        Text(text = weather?.main?.temp?.roundToInt().toString())
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(
    weather: WeatherResponse = WeatherResponse(
        weather = arrayListOf(WeatherDto(1, "mist", "mist", "")),
        main = TemperatureDto(4f, 3f, 1f, 3f, 5f, 5f),
        name = "Debrecen"
    )
) {
    Column {
        Text(text = weather?.name ?: "")
        Text(text = weather?.weather?.get(0)?.description ?: "")
        Text(text = weather?.main?.temp?.roundToInt().toString())
    }
}