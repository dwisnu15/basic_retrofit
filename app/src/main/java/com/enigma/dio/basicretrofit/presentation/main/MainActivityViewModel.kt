package com.enigma.dio.basicretrofit.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enigma.dio.basicretrofit.commonutils.Constants
import com.enigma.dio.basicretrofit.commonutils.ResourceState
import com.enigma.dio.basicretrofit.data.repositories.WeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(val repository : WeatherRepository) : ViewModel() {

    private var _weatherLiveData = MutableLiveData<ResourceState>()
    val weatherLiveData : LiveData<ResourceState>
        get() {
            return _weatherLiveData
        }

    fun getCurrentWeatherData() {
        CoroutineScope(Dispatchers.IO).launch {
            _weatherLiveData.postValue(ResourceState.loading())
            val response = repository.getWeatherInfo(Constants.LAT, Constants.LON)
            if (response.isSuccessful) {
                response.body()?.let {
                    val responseText = "Country: " + it.sys!!.country + "\n" +
                            "Temperature: " + it.main!!.temp + "K"
                    _weatherLiveData.postValue(ResourceState.success(responseText))
                }
            } else {
                _weatherLiveData.postValue(ResourceState.failure("Sorry, error..."))
            }
        }
    }
}