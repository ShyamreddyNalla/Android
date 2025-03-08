package com.example.colorstext

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.appcompat.app.AppCompatActivity
import com.example.colorstext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val REQUEST_COLOR = 10
        const val REQUEST_SIZE = 20
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChangeSize.setOnClickListener {
            val intent = Intent(this, ChangeTextSze::class.java)
            startActivityForResult(intent, REQUEST_SIZE)
        }
        binding.btnChangeColor.setOnClickListener {
            val intent = Intent(this, ColorActivity::class.java)
            startActivityForResult(intent, REQUEST_COLOR)

        }
    }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
            super.onActivityResult(requestCode, resultCode, data)

            if(resultCode == Activity.RESULT_OK && data != null){
                if(requestCode == REQUEST_SIZE){
                    val newSize = data.getFloatExtra("new Size", 20f)
                    binding.textView.textSize = newSize
                }else if(requestCode == REQUEST_COLOR){
                    val newColor = data.getIntExtra("newColor", Color.BLACK)
                    binding.textView.setTextColor(newColor)

                }
            }

        }
    }
