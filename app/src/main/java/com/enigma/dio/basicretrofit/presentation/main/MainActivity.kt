package com.enigma.dio.basicretrofit.presentation.main

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.enigma.dio.basicretrofit.commonutils.ResourceStatus
import com.enigma.dio.basicretrofit.databinding.ActivityMainBinding
import com.enigma.dio.basicretrofit.data.repositories.WeatherRepositoryImpl

class MainActivity : AppCompatActivity() {

    private lateinit var weatherData : TextView
    private lateinit var mainViewModel : MainActivityViewModel
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            button.setOnClickListener {
                mainViewModel.getCurrentWeatherData()
            }
        }
        initViewModel()
        subscribe()
    }



    private fun initViewModel() {
        mainViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val repositoryImpl = WeatherRepositoryImpl()
                return repositoryImpl as T
            }
        }).get(MainActivityViewModel::class.java)
    }

    private fun getCurrentWeatherData() {

    }

    private fun subscribe() {
        mainViewModel.weatherLiveData.observe(this) {
            when (it.resourceStatus) {
                ResourceStatus.LOADING -> Log.d("WeatherApp", "Loading...")

                ResourceStatus.SUCCESS -> {
                    val info = it.data.toString()
                    Log.d("WeatherApp", info)
                    binding.weatherInfoTextView.text = info
                }

                ResourceStatus.FAILURE -> Log.d("WeatherApp", "Error...")
            }
        }
    }

}