package com.uszkaisandor.weathercompose.data.core

sealed class Units(val toStringRepresentation: String) {
    object METRIC: Units("metric")
    object IMPERIAL: Units("imperial")
    object STANDARD: Units("standard")
}