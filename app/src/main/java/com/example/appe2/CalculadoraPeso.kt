package com.example.appe2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlin.math.pow

class CalculadoraPeso : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_peso)

        val alturaEditText: EditText = findViewById(R.id.editTextTextPersonName2)
        val pesoEditText: EditText = findViewById(R.id.editTextTextPersonName)
        val calcularButton: Button = findViewById(R.id.bttonCalcular)
        val resultadoTextView: TextView = findViewById(R.id.textView8)

        calcularButton.setOnClickListener {
            val altura: Double = alturaEditText.text.toString().toDouble() / 100
            val peso: Double = pesoEditText.text.toString().toDouble()

            val bmi: Double = peso / altura.pow(2)

            resultadoTextView.text = "Tu BMI es: %.2f".format(bmi)
        }

        val btn: ImageButton = findViewById(R.id.imageButton2)
        btn.setOnClickListener{
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}