package com.example.module_4.Que15

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.module_4.R
import com.example.module_4.databinding.ActivityRadioBtnBackgroundBinding

class RadioBtnBackgroundActivity : AppCompatActivity() {
    lateinit var binding: ActivityRadioBtnBackgroundBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRadioBtnBackgroundBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    fun onRadioButtonClick(view: View) {
        when (view.id) {
            R.id.rb_red -> binding.layout.setBackgroundResource(R.color.red)
            R.id.rb_green -> binding.layout.setBackgroundResource(R.color.green)
            R.id.rb_blue -> binding.layout.setBackgroundResource(R.color.blue)
            R.id.btn_black -> binding.layout.setBackgroundResource(R.color.black)
            R.id.rb_pink -> binding.layout.setBackgroundResource(R.color.pink)
            R.id.rb_orange -> binding.layout.setBackgroundResource(R.color.orange)
            R.id.rb_sky -> binding.layout.setBackgroundResource(R.color.sky)
        }
    }
}