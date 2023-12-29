package com.example.androidoffline_onlinedatabase.que_4.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.androidoffline_onlinedatabase.databinding.LayoutProfileBinding
import com.example.androidoffline_onlinedatabase.que_4.Models.User


class ProfileAdapter(var context: Context, var studentList: MutableList<User>) :
    Adapter<ProfileAdapter.MyViewHolder>() {

    var itemCardClickListener: ((position: Int, user: User) -> Unit)? = null
    var itemDeleteClickListener: ((position: Int, user: User) -> Unit)? = null
    var itemEditClickListener: ((position: Int, user: User) -> Unit)? = null

    class MyViewHolder(var binding: LayoutProfileBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutProfileBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var user = studentList[position]

        holder.binding.tvLname.text = user.name
        holder.binding.tvLemail.text = user.email
        holder.binding.tvLnumber.text = user.contact

        holder.binding.ivDelete.setOnClickListener {
            itemDeleteClickListener?.invoke(position, user)
        }

        holder.binding.ivEdit.setOnClickListener {
            itemEditClickListener?.invoke(position, user)
        }

        holder.binding.profileLayout1.setOnClickListener {
            itemCardClickListener?.invoke(position, user)
        }
    }

    fun deleteItem(position: Int) {
        studentList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun updateList(mutableList: MutableList<User>){
        studentList = mutableList
        notifyDataSetChanged()
    }

}