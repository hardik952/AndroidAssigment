package com.example.androidoffline_onlinedatabase.que_4.Interface


import com.example.androidoffline_onlinedatabase.que_4.Models.DeleteResponse
import com.example.androidoffline_onlinedatabase.que_4.Models.ProfileResponse
import com.example.androidoffline_onlinedatabase.que_4.Models.RegisterResponse
import com.example.androidoffline_onlinedatabase.que_4.Models.UpdateResponse
import com.example.androidoffline_onlinedatabase.que_4.Models.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("student.php")
    fun create(
        @Field("flag") flag: Int,
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("mobile") contact: String
    ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("student.php")
    fun getStudentList(
       @Field("flag") flag: Int
    ): Call<ProfileResponse>

    @FormUrlEncoded
    @POST("student.php")
    fun deleteStudent(
        @Field("flag") flag:Int,
        @Field("id") id: String
    ):Call<DeleteResponse>

    @FormUrlEncoded
    @POST("student.php")
    fun updateStudent(
        @Field("flag") flag:Int,
        @Field("id") id:String,
        @Field("name") name: String,
        @Field("mobile") contact: String
    ):Call<UpdateResponse>

    @FormUrlEncoded
    @POST("student.php")
    fun getSingleStudent(
        @Field("flag") flag: Int,
        @Field("id") id:String
    ):Call<User>
}