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
class CurrentWeatherViewModel
@Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    val accessKey = BuildConfig.WEATHER_API_KEY

    private val _unit: MutableStateFlow<Units> = MutableStateFlow(Units.METRIC)
    private val _city: MutableStateFlow<String> = MutableStateFlow("Debrecen")
    private val _weather: MutableStateFlow<WeatherResponse?> = MutableStateFlow (null)
    val weather: StateFlow<WeatherResponse?> = _weather

    init {
        getCurrentWeatherByCity()
    }

    fun getCurrentWeatherByCity() {
        viewModelScope.launch {
            _weather.value = repository.getWeatherByCity(
                _unit.value.toStringRepresentation,
                _city.value,
                accessKey
            )
        }
    }


}