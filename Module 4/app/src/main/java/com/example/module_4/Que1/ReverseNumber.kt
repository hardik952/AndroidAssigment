package com.example.module_4.Que1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.module_4.R
import com.example.module_4.databinding.ActivityReverseNumberBinding

class ReverseNumber : AppCompatActivity() {
    lateinit var binding:ActivityReverseNumberBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReverseNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

    binding.etNumber.addTextChangedListener {
//        var originalNum = binding.etNumber.text.toString().trim()
        var originalNum = it.toString()
        var reverseNum = originalNum.reversed()

        binding.tvNumber.text = "Reverse Number :- $reverseNum"
    }
    }
}