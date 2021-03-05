package com.enigma.dio.basicretrofit.data.model

import com.google.gson.annotations.SerializedName

class Coordinate {

    //to call the JSON field with the exact name
    @SerializedName("lon")
    var longitude : Float = 0.toFloat()

    @SerializedName("lat")
    var latitude : Float = 0.toFloat()
}