package com.enigma.dio.basicretrofit.data.model

import com.google.gson.annotations.SerializedName

class Weather {

    @SerializedName("id")
    val id : Float = 0.toFloat()
    @SerializedName("main")
    val main : String? = null
    @SerializedName("description")
    val description : String? = null
    @SerializedName("icon")
    val icon : String? = null
}