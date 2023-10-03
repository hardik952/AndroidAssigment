package com.example.androidassignment.Five

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidassignment.R
import com.example.androidassignment.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity() {
    private lateinit var binding: ActivityLoginPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignupLoginpage.setOnClickListener {
            var intent = Intent(this,RegistrationPage::class.java)
            startActivity(intent)
        }
    }
}