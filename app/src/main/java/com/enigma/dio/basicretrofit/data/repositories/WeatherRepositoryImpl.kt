package com.enigma.dio.basicretrofit.data.repositories

import com.enigma.dio.basicretrofit.data.api.RetrofitInstance
import com.enigma.dio.basicretrofit.data.model.WeatherResponse
import retrofit2.Response

class WeatherRepositoryImpl : WeatherRepository{


    override suspend fun getWeatherInfo(
        lat: Double,
        lon: Double):
            Response<WeatherResponse> =
        RetrofitInstance.getWeatherApiService().getCurrentData(lat, lon)

}