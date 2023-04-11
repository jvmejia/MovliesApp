package com.example.appe2

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.RadioButton
import android.widget.Button
import android.widget.TextView

import android.os.Bundle

class CalculadoraMasa : AppCompatActivity() {
    private lateinit var etWeight: EditText
    private lateinit var etHeight: EditText
    private lateinit var etAge: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var rbMale: RadioButton
    private lateinit var rbFemale: RadioButton
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_masa)

        etWeight = findViewById(R.id.etWeight)
        etHeight = findViewById(R.id.etHeight)
        etAge = findViewById(R.id.etAge)
        rgGender = findViewById(R.id.rgGender)
        rbMale = findViewById(R.id.rbMale)
        rbFemale = findViewById(R.id.rbFemale)
        btnCalculate = findViewById(R.id.btnCalculate)
        tvResult = findViewById(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val weight = etWeight.text.toString().toDouble()
            val height = etHeight.text.toString().toDouble()
            val gender = if (rbMale.isChecked) "Male" else "Female"
            val age = etAge.text.toString().toDouble()

            val bmr = calculateBmr(weight, height, gender, age)
            val calories = calculateCalories(bmr)

            tvResult.text = "Necesitas $calories calorías por día."
        }
    }

    private fun calculateCalories(bmr: Double): Double {
        val sedentary = bmr * 1.2
        val light = bmr * 1.375
        val moderate = bmr * 1.55
        val intense = bmr * 1.725
        val veryIntense = bmr * 1.9

        // Aquí debes determinar el nivel de actividad física de la persona,
        // por ejemplo, leyendo el valor desde un RadioButton o un Spinner
        // y luego calculando las calorías en base al nivel correspondiente.
        // En este ejemplo, se asume que la persona es sedentaria.
        val calories = sedentary

        return calories
    }


    private fun calculateBmr(weight: Double, height: Double, gender: String, age: Double): Double {
        val bmr: Double
        if (gender == "Male") {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age)
        } else {
            bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age)
        }
        return bmr
    }
}
