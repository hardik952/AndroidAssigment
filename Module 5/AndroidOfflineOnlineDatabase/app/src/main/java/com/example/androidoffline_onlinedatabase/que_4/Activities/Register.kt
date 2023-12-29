package com.example.androidoffline_onlinedatabase.que_4.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidoffline_onlinedatabase.databinding.ActivityRegisterBinding
import com.example.androidoffline_onlinedatabase.que_4.Models.RegisterResponse
import com.example.androidoffline_onlinedatabase.que_4.Network.ApiClient
import com.example.androidoffline_onlinedatabase.que_4.PrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {

            var name = binding.etRname.text.toString().trim()
            var email = binding.etRemail.text.toString().trim()
            var contact = binding.etRcontact.text.toString().trim()

            intent.putExtra("NAME",name)
            intent.putExtra("EMAIL",email)
            intent.putExtra("CONTACT",contact)

            create(name, email, contact)

//            var profile = Profile(name = name, email = email, contact = contact)
//
//            var intent = Intent(this, ProfileList::class.java)
//            intent.putExtra("PROFILE", profile)
//            startActivity(intent)
        }
    }

    private fun create(name: String, email: String, contact: String) {
        ApiClient.init().create(1, name = name, email = email, contact = contact).enqueue(object :
            Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful) {

                    var res = response.body()

                    if (res != null) {

                        Toast.makeText(applicationContext, "${res.message}", Toast.LENGTH_SHORT)
                            .show()

                        if (res.status == "success") {
//                      manage shared preference for session management
                            var manager = PrefManager(applicationContext)
                            manager.updateLoginStatus(true)

//                      navigate to homepage
                            var intent =
                                startActivity(Intent(applicationContext, ProfileList::class.java))
                        }
                    }
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.d("TAG", "onFailure: ")
            }
        })
    }
}