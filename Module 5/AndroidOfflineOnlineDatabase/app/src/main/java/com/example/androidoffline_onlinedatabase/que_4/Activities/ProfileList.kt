package com.example.androidoffline_onlinedatabase.que_4.Activity


import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidoffline_onlinedatabase.databinding.ActivityProfileListBinding
import com.example.androidoffline_onlinedatabase.databinding.LayoutBottomsheetBinding
import com.example.androidoffline_onlinedatabase.que_4.Adapter.ProfileAdapter
import com.example.androidoffline_onlinedatabase.que_4.Models.DeleteResponse
import com.example.androidoffline_onlinedatabase.que_4.Models.ProfileResponse
import com.example.androidoffline_onlinedatabase.que_4.Models.UpdateResponse
import com.example.androidoffline_onlinedatabase.que_4.Models.User
import com.example.androidoffline_onlinedatabase.que_4.Network.ApiClient
import com.google.android.material.bottomsheet.BottomSheetDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileList : AppCompatActivity() {
    private lateinit var binding: ActivityProfileListBinding
    private var studentList = mutableListOf<User>()
    private lateinit var profileAdapter: ProfileAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        profileAdapter = ProfileAdapter(this, studentList)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = profileAdapter

        binding.ivBackward.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }

        getStudentList()

        profileAdapter.itemCardClickListener = { position, user ->
            var intent = Intent(this, ProfileDetails::class.java)
            intent.putExtra("STUDENT_ID", user.id)
            startActivity(intent)
        }

        profileAdapter.itemDeleteClickListener = { position, user ->
            showCustomDialog(position, user)
        }

        profileAdapter.itemEditClickListener = { position, user ->
            showBottomSheet(position, user)
        }
    }

    private fun updateStudentDetails(position: Int, user: User) {
        ApiClient.init().updateStudent(2, user.id, user.name, user.contact)
            .enqueue(object : Callback<UpdateResponse> {
                override fun onResponse(
                    call: Call<UpdateResponse>,
                    response: Response<UpdateResponse>
                ) {
                    if (response.isSuccessful) {
                        var student = response.body()

                        if (student?.status == "success") {
                            if (position >= 0 && position < studentList.size) {
                                studentList[position] = user
                                profileAdapter.updateList(studentList)

                            }
                        }
                    }
                }

                override fun onFailure(call: Call<UpdateResponse>, t: Throwable) {
                    Log.d("TAG", "onFailure: ")
                }
            })
    }

    private fun getStudentList() {
        ApiClient.init().getStudentList(4).enqueue(object : Callback<ProfileResponse> {
            override fun onResponse(
                call: Call<ProfileResponse>,
                response: Response<ProfileResponse>
            ) {
                if (response.isSuccessful) {
                    var res = response.body()!!.student

                    res.let {
                        profileAdapter.studentList = it
                        profileAdapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<ProfileResponse>, t: Throwable) {
                Log.d("TAG", "onFailure: ")
            }
        })
    }

    private fun deleteStudent(position: Int, user: User) {
        ApiClient.init().deleteStudent(3, user.id).enqueue(object : Callback<DeleteResponse> {
            override fun onResponse(
                call: Call<DeleteResponse>,
                response: Response<DeleteResponse>
            ) {

                if (response.isSuccessful) {
                    var student = response.body()

                    if (student != null) {
                        if (student.status == "success") {
                            profileAdapter.deleteItem(position)
                            Toast.makeText(
                                applicationContext,
                                "${student.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }

            override fun onFailure(call: Call<DeleteResponse>, t: Throwable) {
                Log.d("TAG", "onFailure: ")
            }
        })
    }

    private fun showCustomDialog(position: Int, user: User) {
        var builder = AlertDialog.Builder(this)
            .setTitle("Delete Profile")
            .setMessage("Are you sure you want to delete this profile")
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                deleteStudent(position, user)
//                Toast.makeText(context, "Profile Deleted", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "Profile not Deleted", Toast.LENGTH_SHORT).show()
            })
        var dialog = builder.create()
        dialog.show()
    }

    private fun showBottomSheet(position: Int, user: User) {

        var bind = LayoutBottomsheetBinding.inflate(LayoutInflater.from(this))

        bind.etEname.setText(user.name)
        bind.tvEemail.setText(user.email)
        bind.etEcontact.setText(user.contact)

        var builder = BottomSheetDialog(this)
        builder.setContentView(bind.root)
        builder.show()

        bind.btnCancel.setOnClickListener {
            builder.dismiss()
        }

        bind.btnUpdate.setOnClickListener {

            user.name = bind.etEname.text.toString()
            user.contact = bind.etEcontact.text.toString()

            updateStudentDetails(position, user)
            builder.dismiss()
        }
    }

    override fun onResume() {
        super.onResume()
        getStudentList()
        profileAdapter.notifyDataSetChanged()
    }
}