package com.andriokar.weatherapp.domain.repository

import com.andriokar.weatherapp.domain.util.Resource
import com.andriokar.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}
