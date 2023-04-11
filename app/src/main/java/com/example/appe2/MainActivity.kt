package com.example.appe2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: ImageButton = findViewById(R.id.imageButton5)
        btn.setOnClickListener{

            val intent: Intent = Intent(this, CalculadoraPeso::class.java)
            startActivity(intent)

        }

        val btnn: ImageButton = findViewById(R.id.imageButton6)
        btnn.setOnClickListener{

            val intent: Intent = Intent(this, CalculadoraMasa::class.java)
            startActivity(intent)

        }


    }

    override fun onBackPressed() {
        // no se realiza ninguna acción al presionar el botón de retroceso
        // para evitar que se cierre la aplicación
    }

}