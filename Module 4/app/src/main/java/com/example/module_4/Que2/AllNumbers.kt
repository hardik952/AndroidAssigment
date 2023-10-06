package com.example.module_4.Que2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.module_4.R
import com.example.module_4.databinding.ActivityAllNumbersBinding

class AllNumbers : AppCompatActivity() {
    lateinit var binding: ActivityAllNumbersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllNumbersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var num1 = intent.getIntExtra("NUM1",0)
        var num2 = intent.getIntExtra("NUM2",0)

        var numbers  = if (num1<=num2){
            (num1..num2).toList()
        }else{
            (num2..num1).toList()
        }

        binding.tvNumbers.text = """
            Series = ${numbers}
        """.trimIndent()
    }
}