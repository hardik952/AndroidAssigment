package com.example.androidassignment.ThreeAndFour

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidassignment.databinding.ActivityScreenNavigateBinding

class ScreenNavigate : AppCompatActivity() {

    private lateinit var binding: ActivityScreenNavigateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScreenNavigateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            var email = binding.etEmail.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()

            var intent = Intent(this,ScreenNavigate2::class.java)
            intent.putExtra("EMAIL",email)
            intent.putExtra("PASSWORD",password)
            startActivity(intent)
        }
    }
}