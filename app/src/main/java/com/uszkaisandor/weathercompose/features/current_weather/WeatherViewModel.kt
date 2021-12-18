package com.uszkaisandor.weathercompose.features.current_weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uszkaisandor.weathercompose.BuildConfig
import com.uszkaisandor.weathercompose.api.response.WeatherResponse
import com.uszkaisandor.weathercompose.data.core.Units
import com.uszkaisandor.weathercompose.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel
@Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    val accessKey = BuildConfig.WEATHER_API_KEY

    private val _unit: MutableStateFlow<Units> = MutableStateFlow(Units.METRIC)
    private val _latitude: MutableStateFlow<Float> = MutableStateFlow(47.53333f)
    private val _longitude: MutableStateFlow<Float> = MutableStateFlow(21.63333f)
    private val _language: MutableStateFlow<String> = MutableStateFlow("hu")
    private val _weather: MutableStateFlow<WeatherResponse?> = MutableStateFlow(null)
    val weather: StateFlow<WeatherResponse?> = _weather

    init {
        getWeatherByCoordinates()
    }

    private fun getWeatherByCoordinates() {
        viewModelScope.launch {
            _weather.value = repository.getWeatherByCity(
                _latitude.value,
                _longitude.value,
                _unit.value.toStringRepresentation,
                accessKey,
                language = _language.value
            )
        }
    }


}