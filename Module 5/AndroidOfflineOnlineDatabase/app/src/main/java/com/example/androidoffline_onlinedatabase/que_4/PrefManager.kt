package com.example.androidoffline_onlinedatabase.que_4

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class PrefManager(var context: Context) {

    private val PREF_NAME = "com.example.apirequests"
    private val KEY_LOGIN = "login"

    var preferences :SharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
    var editor:Editor = preferences.edit()

    fun getLoginStatus():Boolean{
        return preferences.getBoolean(KEY_LOGIN,false)
    }

    fun updateLoginStatus(status:Boolean){
        editor.putBoolean(KEY_LOGIN,status)
        editor.commit()
    }
}