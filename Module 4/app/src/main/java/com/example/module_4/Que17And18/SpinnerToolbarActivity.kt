package com.example.module_4.Que17And18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.SpinnerAdapter
import android.widget.Toast
import com.example.module_4.R
import com.example.module_4.databinding.ActivitySpinnerToolbarBinding
import java.text.FieldPosition

class SpinnerToolbarActivity : AppCompatActivity() {
    lateinit var binding: ActivitySpinnerToolbarBinding
    lateinit var colourAdapter: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpinnerToolbarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val colourList = resources.getStringArray(R.array.colorArray)

        colourAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,colourList)
        binding.spinner.adapter = colourAdapter
        binding.spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                index: Int,
                id: Long
            ) {
                var   colour =colourList[index]
                Toast.makeText(applicationContext,"$colour",Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }
}