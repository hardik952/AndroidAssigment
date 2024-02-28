package com.example.androidassignment.Nine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidassignment.R
import com.example.androidassignment.databinding.ActivityQueNine2Binding

class QueNineActivity : AppCompatActivity() {
    lateinit var binding: ActivityQueNine2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQueNine2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnGoToFragment.setOnClickListener {

            var queNineFragment = QueNineFragment()
            var manager = supportFragmentManager
            var transaction = manager.beginTransaction()
            transaction.add(R.id.fragment_container, queNineFragment)
            transaction.commit()
        }

    }
}