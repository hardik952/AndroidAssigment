package com.example.module_4.Que14

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.module_4.R
import com.example.module_4.databinding.ActivityStringListviewBinding

class StringListview : AppCompatActivity() {
    lateinit var binding: ActivityStringListviewBinding
    lateinit var colorAdapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStringListviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val array = resources.getStringArray(R.array.colorArray)

        colorAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
        binding.listView.adapter = colorAdapter

        binding.listView.setOnItemClickListener { adapterView, view, position, id ->

            var color = array[position]
            Toast.makeText(this, "$color", Toast.LENGTH_SHORT).show()
        }
    }
}