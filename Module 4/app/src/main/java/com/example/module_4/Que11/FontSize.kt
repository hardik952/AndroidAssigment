package com.example.module_4.Que11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import androidx.core.util.rangeTo
import com.example.module_4.R
import com.example.module_4.databinding.ActivityFontSizeBinding
import java.lang.StringBuilder

class FontSize : AppCompatActivity() {
    lateinit var binding: ActivityFontSizeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFontSizeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var txtSize:Float = 16f
        binding.btnIncre.setOnClickListener {
        txtSize++
//      binding.text1.setTextSize(textSize)  OR
            binding.text1.textSize = txtSize
        }
        binding.btnDecre.setOnClickListener {
            txtSize--
            binding.text1.textSize = txtSize
        }
    }
}