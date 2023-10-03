package com.example.androidassignment.Two

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.content.contentValuesOf
import com.example.androidassignment.R
import com.example.androidassignment.databinding.ActivityChangeBgBinding

class ChangeBgActivity : AppCompatActivity() {
    lateinit var binding: ActivityChangeBgBinding
    private var colorList = mutableListOf<Int>(R.color.black,R.color.blue,R.color.green,R.color.red,R.color.pink,R.color.orange)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangeBgBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            binding.layoutMain.setBackgroundColor(ContextCompat.getColor(this,getRandomColor()))
        }
    }

    private fun getRandomColor(): Int {
        return colorList.shuffled().last()

    }


}