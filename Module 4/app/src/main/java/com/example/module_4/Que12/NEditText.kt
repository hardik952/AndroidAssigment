package com.example.module_4.Que12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.module_4.databinding.ActivityNeditTextBinding


class NEditText : AppCompatActivity() {
    lateinit var binding: ActivityNeditTextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNeditTextBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnClick.setOnClickListener {

            val number = binding.etNumber.text.toString().trim().toInt()

            for (i in 0 until number) {
                val editText = EditText(this)
                editText.hint = "EditText ${i + 1}"
                binding.layout.addView(editText)
            }
        }

        binding.btnReset.setOnClickListener {
            binding.etNumber.text.clear()
           binding.layout.removeAllViews()
        }

    }
}