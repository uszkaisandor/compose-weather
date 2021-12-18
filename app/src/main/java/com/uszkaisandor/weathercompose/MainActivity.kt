package com.uszkaisandor.weathercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uszkaisandor.weathercompose.data.dto.WeatherDescriptor
import com.uszkaisandor.weathercompose.data.dto.WeatherDto
import com.uszkaisandor.weathercompose.features.current_weather.WeatherViewModel
import com.uszkaisandor.weathercompose.features.current_weather.view.CurrentWeather
import com.uszkaisandor.weathercompose.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint

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
fun WeatherScreen(viewModel: WeatherViewModel = viewModel()) {
    val weather = viewModel.weather.collectAsState().value
    weather?.let {
        CurrentWeather(weather = it.current)
    }
}