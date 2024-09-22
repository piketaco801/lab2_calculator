package com.cs407.lab2_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1 = findViewById<EditText>(R.id.editTextNumber1)
        val number2 = findViewById<EditText>(R.id.editTextNumber2)

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonSubtract = findViewById<Button>(R.id.buttonSubtract)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)

        buttonAdd.setOnClickListener {
            val result = number1.text.toString().toDouble() + number2.text.toString().toDouble()
            navigateToResult(result)
        }

        buttonSubtract.setOnClickListener {
            val result = number1.text.toString().toDouble() - number2.text.toString().toDouble()
            navigateToResult(result)
        }

        buttonMultiply.setOnClickListener {
            val result = number1.text.toString().toDouble() * number2.text.toString().toDouble()
            navigateToResult(result)
        }

        buttonDivide.setOnClickListener {
            val divisor = number2.text.toString().toDouble()
            if (divisor == 0.0) {
                // Handle divide by zero error
                navigateToResult(Double.NaN)
            } else {
                val result = number1.text.toString().toDouble() / divisor
                navigateToResult(result)
            }
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, calculator::class.java) // 혹은 정확한 클래스 이름
        intent.putExtra("result", result)
        startActivity(intent)
    }

}
