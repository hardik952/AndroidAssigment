package com.example.module_4

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.module_4.Que1.ReverseNumber
import com.example.module_4.Que11.FontSize
import com.example.module_4.Que2.BetweenNumbers
import com.example.module_4.Que3.RadioBtnMath
import com.example.module_4.Que4.ActivityFragment
import com.example.module_4.Que8.HideTextActivity
import com.example.module_4.databinding.QuestionListLayoutBinding

class QuestionListAdapter(var context: Context,var questionList: MutableList<Question>): Adapter<QuestionListAdapter.MyViewHolder>() {
    class MyViewHolder(var binding:QuestionListLayoutBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = QuestionListLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(view)
        }

    override fun getItemCount(): Int {
        return questionList.size
        }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var questions = questionList[position]
        holder.binding.tvQuestion.text = questions.question

        holder.binding.tvQuestion.setOnClickListener {
            when(questions.id){
                1 -> context.startActivity(Intent(context,ReverseNumber::class.java))
                2 -> context.startActivity(Intent(context,BetweenNumbers::class.java))
                3 -> context.startActivity(Intent(context,RadioBtnMath::class.java))
                4 -> context.startActivity(Intent(context,ActivityFragment::class.java))
                5 -> context.startActivity(Intent(context,ReverseNumber::class.java))
                6 -> context.startActivity(Intent(context,ReverseNumber::class.java))
                7 -> context.startActivity(Intent(context,ReverseNumber::class.java))
                8 -> context.startActivity(Intent(context, HideTextActivity::class.java))
                9 -> context.startActivity(Intent(context,ReverseNumber::class.java))
                10 -> context.startActivity(Intent(context,ReverseNumber::class.java))
                11 -> context.startActivity(Intent(context,FontSize::class.java))
                12 -> context.startActivity(Intent(context,ReverseNumber::class.java))
                13 -> context.startActivity(Intent(context,ReverseNumber::class.java))
                14 -> context.startActivity(Intent(context,ReverseNumber::class.java))
                15 -> context.startActivity(Intent(context,ReverseNumber::class.java))
                16 -> context.startActivity(Intent(context,ReverseNumber::class.java))
                17 -> context.startActivity(Intent(context,ReverseNumber::class.java))
                18 -> context.startActivity(Intent(context,ReverseNumber::class.java))
            }
        }
        }
}