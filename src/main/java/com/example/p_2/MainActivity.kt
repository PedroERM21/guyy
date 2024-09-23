package com.example.p_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.P_2.DisplayActivity

class MainActivity : AppCompatActivity() {
    private lateinit var nombre: EditText
    private lateinit var edad: EditText
    private lateinit var btnAceptar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre = findViewById(R.id.nombre)
        edad = findViewById(R.id.edad)
        btnAceptar = findViewById(R.id.btnAceptar)

        btnAceptar.setOnClickListener {
            val name = nombre.text.toString()
            val age = edad.text.toString()

            val intent = Intent(this, DisplayActivity::class.java).apply {
                putExtra("name", name)
                putExtra("age", age)
            }
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }
    }
}