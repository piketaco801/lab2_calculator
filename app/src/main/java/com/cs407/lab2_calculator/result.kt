package com.cs407.lab2_calculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class calculator : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getDoubleExtra("result", 0.0)

        val resultTextView = findViewById<TextView>(R.id.textViewResult)
        resultTextView.text = "Result: $result"
    }
}
