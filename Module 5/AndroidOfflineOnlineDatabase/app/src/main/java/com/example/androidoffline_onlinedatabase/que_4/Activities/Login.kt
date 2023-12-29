package com.example.androidoffline_onlinedatabase.que_4.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidoffline_onlinedatabase.databinding.ActivityLoginBinding
import com.example.androidoffline_onlinedatabase.que_4.PrefManager


class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            var manager = PrefManager(this)
            manager.updateLoginStatus(true)
            var intent = startActivity(Intent(this, ProfileList::class.java))
        }

        binding.btnSignup.setOnClickListener {
            var intent = startActivity(Intent(this, Register::class.java))
        }


    }
}