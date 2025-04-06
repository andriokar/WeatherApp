package com.andriokar.weatherapp.data.repository

import com.andriokar.weatherapp.data.mappers.toWeatherInfo
import com.andriokar.weatherapp.data.remote.WeatherApi
import com.andriokar.weatherapp.domain.repository.WeatherRepository
import com.andriokar.weatherapp.domain.util.Resource
import com.andriokar.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {

    override suspend fun getWeatherData(
        lat: Double,
        long: Double
    ): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (exception: Exception) {
            exception.run { printStackTrace() }
            Resource.Error(exception.message ?: "An unknow error occurred")
        }
    }
}
