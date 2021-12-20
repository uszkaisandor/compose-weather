package com.uszkaisandor.weathercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uszkaisandor.weathercompose.features.current_weather.WeatherViewModel
import com.uszkaisandor.weathercompose.features.current_weather.view.CurrentWeather
import com.uszkaisandor.weathercompose.features.hourly_forecast.HourlyForecast
import com.uszkaisandor.weathercompose.features.weather_forecast.DailyForecast
import com.uszkaisandor.weathercompose.ui.theme.WeatherTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.surface) {
                    WeatherScreen()
                }
            }
        }
    }
}

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = viewModel()) {
    val weather = viewModel.weather.collectAsState().value
    Column() {
        CurrentWeather(weather = weather?.current)
        HourlyForecast(weatherList = weather?.hourly)
        DailyForecast(weatherList = weather?.daily)
    }
}

