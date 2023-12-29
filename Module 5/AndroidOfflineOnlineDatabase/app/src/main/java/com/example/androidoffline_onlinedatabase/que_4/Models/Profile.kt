package com.example.androidoffline_onlinedatabase.que_4.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Profile(
    var name: String,
    var email: String,
    var contact: String
) : Parcelable
