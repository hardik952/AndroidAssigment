package com.example.androidassignment.Six

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidassignment.R
import com.example.androidassignment.databinding.ActivityQue6Binding

class Que6 : AppCompatActivity() {
    private lateinit var binding: ActivityQue6Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQue6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvQueSix.text = "Que: What is R.java file?\n" +
                "Ans:\n->Android R.java is an auto-generated file by aapt (Android Asset Packaging Tool) that contains resource IDs for all the resources of res/ directory.\n" +
                "-> If you create any component in the activity_main.xml file, id for the corresponding component is automatically created in this file. \n-> This id can be used in the activity source file to perform any action on the component."
    }
}