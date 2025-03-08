package com.example.colorstext

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.colorstext.databinding.ActivityColorBinding

class ColorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityColorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val colorNames = arrayOf("Red", "Green", "Blue", "Yellow", "Black", "Cyan")
        val colorValues = arrayOf(
            android.graphics.Color.RED,
            android.graphics.Color.GREEN,
            android.graphics.Color.BLUE,
            android.graphics.Color.YELLOW,
            android.graphics.Color.BLACK,
            android.graphics.Color.CYAN
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, colorNames)
        binding.spinnerColor.adapter = adapter

        binding.btnSetColor.setOnClickListener {
            val selectedIndex = binding.spinnerColor.selectedItemPosition
            val selectedColor = colorValues[selectedIndex]

            val resultIntent = Intent().apply {
                putExtra("newColor", selectedColor)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}