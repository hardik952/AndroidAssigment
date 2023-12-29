package com.example.androidoffline_onlinedatabase.que_4.Models

import com.google.gson.annotations.SerializedName

data class User(
    var id:String,
    var name:String,
    var email:String,
    @SerializedName("mobile")
    var contact:String
)
