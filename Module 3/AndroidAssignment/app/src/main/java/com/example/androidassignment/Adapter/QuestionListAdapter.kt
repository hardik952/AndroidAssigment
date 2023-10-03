package com.example.androidassignment.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.androidassignment.Eight.Que8
import com.example.androidassignment.Five.LoginPage
import com.example.androidassignment.One.HelloWorldActivity
import com.example.androidassignment.Nine.QueNineActivity
import com.example.androidassignment.Questions
import com.example.androidassignment.Seven.Que7
import com.example.androidassignment.Six.Que6
import com.example.androidassignment.ThreeAndFour.ScreenNavigate
import com.example.androidassignment.Two.ChangeBgActivity
import com.example.androidassignment.databinding.QuestionListLayoutBinding

class QuestionListAdapter(var context: Context, var questionList: MutableList<Questions>) :
    Adapter<QuestionListAdapter.MyViewHolder>() {

    class MyViewHolder(var binding: QuestionListLayoutBinding) : ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var binding = QuestionListLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var question = questionList[position]
        holder.binding.tvQuestions.text = question.question

        holder.binding.tvQuestions.setOnClickListener {
            when (question.id) {
                1 -> context.startActivity(Intent(context, HelloWorldActivity::class.java))
                2 -> context.startActivity(Intent(context, ChangeBgActivity::class.java))
                3, 4 -> context.startActivity(Intent(context, ScreenNavigate::class.java))
                5 -> context.startActivity(Intent(context, LoginPage::class.java))
                6 -> context.startActivity(Intent(context, Que6::class.java))
                7 -> context.startActivity(Intent(context, Que7::class.java))
                8 -> context.startActivity(Intent(context, Que8::class.java))
                9 -> context.startActivity(Intent(context, QueNineActivity::class.java))

            }
        }
    }
}