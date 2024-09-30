package com.example.scrool

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class HLActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos)

        val foodImageView: ImageView = findViewById(R.id.imageView)
        val descriptionTextView: TextView = findViewById(R.id.textViewDescription)
        val countryTextView: TextView = findViewById(R.id.textViewCountry)
        val countryImageView: ImageView = findViewById(R.id.countryImageView)
        val buttonShare: Button = findViewById(R.id.buttonShare)

        val foodName = intent.getStringExtra("nombre")
        val foodDescription = intent.getStringExtra("descripcion")
        val countryName = intent.getStringExtra("pais")
        val foodImageResId = intent.getIntExtra("foodImage", R.drawable.default_flag)
        val countryImageResId = intent.getIntExtra("countryImage", R.drawable.default_flag)

        foodImageView.setImageResource(foodImageResId)
        descriptionTextView.text = foodDescription
        countryTextView.text = countryName
        countryImageView.setImageResource(countryImageResId)

        buttonShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Estoy compartiendo $foodName de $countryName.")
            }
            startActivity(Intent.createChooser(shareIntent, "Compartir Via"))
        }
    }
}
