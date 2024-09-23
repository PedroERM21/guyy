package com.example.P_2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.p_2.R

class DisplayActivity : AppCompatActivity() {
    private lateinit var displayName: TextView
    private lateinit var displayAge: TextView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        displayName = findViewById(R.id.displayName)
        displayAge = findViewById(R.id.displayAge)

        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")

        displayName.text = "Nombre: $name"
        displayAge.text = "Edad: $age"
    }
}
