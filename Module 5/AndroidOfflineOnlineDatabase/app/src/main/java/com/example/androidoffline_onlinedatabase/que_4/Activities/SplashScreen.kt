package com.example.androidoffline_onlinedatabase.que_4.Activity


import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.example.androidoffline_onlinedatabase.databinding.ActivitySplashScreenBinding
import com.example.androidoffline_onlinedatabase.que_4.PrefManager


class SplashScreen : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }

        Thread(Runnable {
            Thread.sleep(2000)
            var manager = PrefManager(this)
            if (manager.getLoginStatus()){
                var intent = startActivity(Intent(this,Login::class.java))
            }else{
                var intent = startActivity(Intent(this,Login::class.java))
            }
        }).start()
    }
}