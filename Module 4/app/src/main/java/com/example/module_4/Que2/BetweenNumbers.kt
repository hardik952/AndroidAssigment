package com.example.module_4.Que2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module_4.databinding.ActivityBetweenNumbersBinding

class BetweenNumbers : AppCompatActivity() {
    lateinit var binding: ActivityBetweenNumbersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBetweenNumbersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDone.setOnClickListener {

            var num1 = binding.etNum1.text.toString().trim().toInt()
            var num2 = binding.etNum2.text.toString().trim().toInt()

            var intent = Intent(this, AllNumbers::class.java)

            intent.putExtra("NUM1", num1.toInt())
            intent.putExtra("NUM2", num2.toInt())
            startActivity(intent)

        }
    }
}