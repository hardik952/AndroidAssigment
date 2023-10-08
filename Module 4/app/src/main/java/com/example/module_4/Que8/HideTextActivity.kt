package com.example.module_4.Que8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.module_4.databinding.ActivityHideTextBinding

class HideTextActivity : AppCompatActivity() {

    lateinit var binding: ActivityHideTextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHideTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var text = binding.tvText.text.toString().trim()

        binding.btnHide.setOnClickListener {
            binding.tvText.visibility = View.GONE
        }
        binding.btnShow.setOnClickListener {
            binding.tvText.visibility = View.VISIBLE
        }
    }
}