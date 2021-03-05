package com.enigma.dio.basicretrofit.data.repositories

import com.enigma.dio.basicretrofit.data.model.WeatherResponse
import retrofit2.Response


interface WeatherRepository {
    suspend fun getWeatherInfo(lat : Double, lon : Double) : Response<WeatherResponse>
}