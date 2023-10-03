package com.example.androidassignment.ThreeAndFour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidassignment.databinding.ActivityScreenNavigate2Binding

class ScreenNavigate2 : AppCompatActivity() {

    private lateinit var binding: ActivityScreenNavigate2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenNavigate2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var email = intent.getStringExtra("EMAIL")
        var password = intent.getStringExtra("PASSWORD")

        binding.tvDetails.text= """
            email = ${email}
            password = ${password}
        """.trimIndent()
    }
}