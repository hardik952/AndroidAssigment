package com.example.androidoffline_onlinedatabase.que_4.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidoffline_onlinedatabase.databinding.ActivityProfileDetailsBinding
import com.example.androidoffline_onlinedatabase.que_4.Models.User
import com.example.androidoffline_onlinedatabase.que_4.Network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileDetails : AppCompatActivity() {

    private lateinit var binding: ActivityProfileDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackward.setOnClickListener {
            var intent = Intent(this, ProfileList::class.java)
            startActivity(intent)
        }
        var studentId = intent.getStringExtra("STUDENT_ID")

        showStudentProfile(studentId.toString())
    }

    private fun showStudentProfile(studentId: String) {
        ApiClient.init().getSingleStudent(5,studentId).enqueue(object : Callback<User> {
            override fun onResponse(
                call: Call<User>,
                response: Response<User>
            ) {
                if (response.isSuccessful){
                    var student = response.body()
                    student?.let {
                        binding.tvDname.text = student.name
                        binding.tvDemail.text = student.email
                        binding.tvDcontact.text = student.contact
                    }
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.d("TAG", "onFailure: ")
            }
        })
    }
}