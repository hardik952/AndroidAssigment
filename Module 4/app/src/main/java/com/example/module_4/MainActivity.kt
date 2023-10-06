package com.example.module_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var questionList = mutableListOf<Question>()
    lateinit var questionAdapter: QuestionListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        questionAdapter = QuestionListAdapter(this,questionList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = questionAdapter

    }

    private fun prepareData() {
        questionList.add(
            Question(
                1, "1. Create an application to take input number from user and print its reverse number in TextView without button."))
        questionList.add(
            Question(
                2, "2. Create an application to input 2 numbers from user and all numbers between those 2 numbers in next activity"))
        questionList.add(
            Question(
                3, "3. Create an application with radio buttons (Add, Subtraction, Multiply, Division) EditText (number1, number2) and print result as per user choice from radio button in TextView "))
        questionList.add(
            Question(
                4, "4. Write a code to display login form when click on login button and registration form when click on registration button on single activity using fragment"))
        questionList.add(
            Question(
                5, "5. Create an application to load google url into webview also manage forward and backward redirect"))
        questionList.add(
            Question(
                6, "6. In Previous Practical write code to check weather internet connection is available or not if"))
        questionList.add(
            Question(
                7, "7. no internet connection then display message accordingly"))
        questionList.add(
            Question(
                8, "8. create an application to hide TextView when first button click and show when second button click "))
        questionList.add(
            Question(
                9, "9. Create an application to add TextView in TableLayout Programmatically "))
        questionList.add(
            Question(
                10, "10. create an application to open pdf using implicit intent "))
        questionList.add(
            Question(
                11, "11. create an application to increate font size when plus button click and decrease when minus button click "))
        questionList.add(
            Question(
                12, "12. create an application to display n edittext where n is number input by user "))
        questionList.add(
            Question(
                13, "13. Create an application to display Textview when checkbox is checked and hide otherwise A6 Write a program to show four images around Textview"))
        questionList.add(
            Question(
                14, "14. Write a program to create one string array in string.xml file and that array show in listview"))
        questionList.add(
            Question(
                15, "15. Write a program in android display screen color which the Color will be select from the radio button"))
        questionList.add(
            Question(
                16, "16. Write a program you have taken three seek bar controls. From three Seekbar which Seek bar value changed the background color of device will be changed."))
        questionList.add(
            Question(
                17, "17. Create custom toolbar as per given below design "))
        questionList.add(
            Question(
                18, "18. Create toolbar with spinner and search functionality "))

    }
}