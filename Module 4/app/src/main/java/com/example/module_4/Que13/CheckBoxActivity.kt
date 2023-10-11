package com.example.module_4.Que13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import com.example.module_4.R
import com.example.module_4.databinding.ActivityCheckBoxBinding

class CheckBoxActivity : AppCompatActivity() {
    lateinit var binding: ActivityCheckBoxBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckBoxBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkBox.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked) binding.tvText1.visibility = View.VISIBLE
            else binding.tvText1.visibility = View.GONE
        }
    }
}