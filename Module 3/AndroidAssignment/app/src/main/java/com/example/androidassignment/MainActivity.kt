package com.example.androidassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidassignment.Adapter.QuestionListAdapter
import com.example.androidassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var questionList = mutableListOf<Questions>()
    private lateinit var questionListAdapter: QuestionListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        questionListAdapter = QuestionListAdapter(this, questionList)
        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = questionListAdapter
    }

    private fun prepareData() {
        questionList.add(Questions(1, "1. Create “hello world” application"))
        questionList.add(
            Questions(
                2,
                "2. Change screen background color on different button click event"
            )
        )
        questionList.add(Questions(3, "3. Navigate between one screen to another screen"))
        questionList.add(Questions(4, "4. Pass data from one screen to second screen"))
        questionList.add(Questions(5, "5. Design login and registration screen"))
        questionList.add(Questions(6, "6. What is R.java file"))
        questionList.add(Questions(7, "7. What is activity and activity lifecycle"))
        questionList.add(Questions(8, "8. What is fragment and fragment lifecycle"))
        questionList.add(Questions(9, "9. Activity to fragment and fragment to activity"))
    }
}