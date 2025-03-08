package com.example.colorstext

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.colorstext.databinding.ActivityChangeTextSizeBinding

class ChangeTextSze : AppCompatActivity() {

    private lateinit var binding: ActivityChangeTextSizeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChangeTextSizeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sizes = arrayOf("10sp", "20sp", "24sp", "32sp", "36sp", "40sp")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sizes)
        binding.spinner.adapter = adapter

        binding.btnSetSize.setOnClickListener {
            val selectedSize = binding.spinner.selectedItem.toString()
            val sizeInFloat = selectedSize.replace("sp", "").toFloat()

            val resultIntent = Intent().apply {
                putExtra("newSize", sizeInFloat)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
