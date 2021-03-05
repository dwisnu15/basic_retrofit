package com.enigma.dio.basicretrofit.data.api


import com.enigma.dio.basicretrofit.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    //singleton okhttpclient
    val okhttp3Client = OkHttpClient.Builder().addInterceptor(ApiKeyInterceptor()).build()
    //build the retrofit
    val retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).client(okhttp3Client)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getWeatherApiService() = retrofit.create(WeatherApi::class.java)
}