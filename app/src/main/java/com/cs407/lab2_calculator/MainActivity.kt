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
            val result = calculateResult(number1.text.toString(), number2.text.toString()) { a, b -> a + b }
            navigateToResult(result)
        }

        buttonSubtract.setOnClickListener {
            val result = calculateResult(number1.text.toString(), number2.text.toString()) { a, b -> a - b }
            navigateToResult(result)
        }

        buttonMultiply.setOnClickListener {
            val result = calculateResult(number1.text.toString(), number2.text.toString()) { a, b -> a * b }
            navigateToResult(result)
        }

        buttonDivide.setOnClickListener {
            val result = calculateResult(number1.text.toString(), number2.text.toString()) { a, b ->
                if (b == 0.0) Double.NaN else a / b
            }
            navigateToResult(result)
        }
    }

    private fun calculateResult(input1: String, input2: String, operation: (Double, Double) -> Double): Double {
        return try {
            if (input1.isBlank() || input2.isBlank()) {
                Double.NaN
            } else {
                val num1 = input1.toDouble()
                val num2 = input2.toDouble()
                operation(num1, num2)
            }
        } catch (e: NumberFormatException) {
            Double.NaN
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, calculator::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }
}
