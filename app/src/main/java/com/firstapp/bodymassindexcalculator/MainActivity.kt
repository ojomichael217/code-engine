package com.firstapp.bodymassindexcalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(/* layoutResID = */ R.layout.activity_main)

        val weightText = findViewById<EditText>(R.id.textViewWeight)
        val heightText =findViewById<EditText>(R.id.textViewHeight)
        val calcButton = findViewById<Button>(R.id.buttonCalculator)

        calcButton.setOnClickListener {
            val weight = weightText.text.toString()
            val height = heightText.text.toString()

            val bodyMassIndex = weight.toFloat()/((height.toFloat()/100)*(height.toFloat()/100))
            val bodyMassIndex20Digits =String.format("%.2f", bodyMassIndex).toFloat()
            displayResult(bodyMassIndex20Digits)
        }
    }
    private fun displayResult(bodyMassIndex:Float) {
    val resultIndex = findViewById<TextView>(R.id.textViewIndex)
        findViewById<TextView>(R.id.textViewResult)
    val info =findViewById<TextView>(R.id.textViewInformation)

        resultIndex.text =bodyMassIndex.toString()
        info.text = buildString {
        append("Normal range is 18.5 - 24.9")
    }
        var resultText=""
        var color= 0

        when {
            bodyMassIndex< 18.50->{
                resultText = "underweight"
                color = R.color.under_weight
            }
            bodyMassIndex in 18.50..24.99 -> {
                resultText = "healthy"
                color = R.color.normal
            }
            bodyMassIndex in 25.00..25.99 -> {
                resultText = "Overweight"
                color = R.color.over_weight
            }
            bodyMassIndex>29.99 -> {
                resultText ="Obese"
                color= R.color.obese
            }
        }


    }
}