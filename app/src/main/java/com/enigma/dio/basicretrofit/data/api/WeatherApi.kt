package com.enigma.dio.basicretrofit.data.api

import com.enigma.dio.basicretrofit.data.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    //get data from api by calling the url
    @GET("data/2.5/weather?")
    fun getCurrentData(
        @Query("lat") lat : Double,
        @Query("lon") long : Double) : Response<WeatherResponse>
}