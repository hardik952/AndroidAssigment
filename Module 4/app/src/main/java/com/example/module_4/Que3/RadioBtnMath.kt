package com.example.module_4.Que3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Checkable
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.module_4.R
import com.example.module_4.databinding.ActivityRadioBtnMathBinding

class RadioBtnMath : AppCompatActivity() {
    lateinit var binding: ActivityRadioBtnMathBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        var ans: Double = 0.0
        super.onCreate(savedInstanceState)
        binding = ActivityRadioBtnMathBinding.inflate(layoutInflater)
        setContentView(binding.root)

            binding.radioGroup.setOnCheckedChangeListener { radioGroup, id ->

                var num1 = binding.num1.text.toString().trim().toDouble()
                var num2 = binding.num2.text.toString().trim().toDouble()

                when (id) {
                    R.id.btn_add -> ans = num1.plus(num2)
                    R.id.btn_sub -> ans = num1.minus(num2)
                    R.id.btn_multi -> ans = num1.times(num2)
                    R.id.btn_div -> ans = num1.div(num2).toDouble()
                }

                binding.tvAns.text = """ your Answer :- $ans""".trimIndent()
            }
    }
}

