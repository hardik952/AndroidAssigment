package com.example.androidassignment.Seven

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidassignment.R
import com.example.androidassignment.databinding.ActivityQue7Binding

class Que7 : AppCompatActivity() {
    private lateinit var binding: ActivityQue7Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQue7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvQueSeven.text =
            "Que: What is activity and activity lifecycle?\nAns:\n" +
                    "->An activity is one screen of an app. \n" +
                    "->In that way the activity is very similar to a window in the Windows operating system. \n" +
                    "->The most specific block of the user interface is the activity. \n" +
                    "->An Android app contains activities, meaning one or more screens. \n" +
                    "->Examples: Login screen, sign up screen, and home screen.\n\n*ACTIVITY LIFECYCLE:"
    }
}