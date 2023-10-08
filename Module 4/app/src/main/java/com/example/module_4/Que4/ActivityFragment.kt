package com.example.module_4.Que4

import android.content.Context
import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.module_4.R
import com.example.module_4.databinding.ActivityFragmentBinding

class ActivityFragment : AppCompatActivity() {
    lateinit var binding: ActivityFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnlogin.setOnClickListener {
            addFragment(LoginFragment())

        }
        binding.btnregister.setOnClickListener {
            addFragment(RegisterFragment())
        }
    }
    fun addFragment(fragment: Fragment){
        var manager = supportFragmentManager
        var transaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
    }
}