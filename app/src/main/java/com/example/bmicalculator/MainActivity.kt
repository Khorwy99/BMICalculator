package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import android.widget.Toast.makeText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculate.setOnClickListener() {

            try {
                val weight: Double = getWeight.text.toString().toDouble()
                val height: Double = getHeight.text.toString().toDouble()
                val bmi: Double = calculateBMI(weight, height)
                val status: String



                if (bmi < 18.50) {
                    image.setImageResource(R.drawable.under)
                } else if (bmi <= 24.9) {
                    image.setImageResource(R.drawable.normal)
                } else {
                    image.setImageResource(R.drawable.over)
                }

                when {
                    bmi < 18.5 -> {
                        image.setImageResource(R.drawable.under)
                        status = "Under"
                    }
                    bmi < 24.9 -> {
                        image.setImageResource(R.drawable.normal)
                        status = "Normal"
                    }
                    else -> {
                        image.setImageResource(R.drawable.over)
                        status = "Over"
                    }
                }

                disResult.text = "BMI %.2f(%s)".format(bmi, status)
            }

                catch(ex: Exception) {
                    val toast: Toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG)

                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()

                }
        }

            reset.setOnClickListener() {
                image.setImageResource(R.drawable.empty)
                disResult.setText("")
                getWeight.setText("")
                getHeight.setText("")
            }
        }

        fun calculateBMI(weight: Double, height: Double): Double {
            return weight / Math.pow(height, 2.0)
        }
    }

