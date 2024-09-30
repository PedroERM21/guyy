package com.example.scrool

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var searchView: SearchView
    private lateinit var adapter: Adaptado

    // Lista de platillos con nombre, país, imagen de platillo y bandera del país
    private val foodList = listOf(
        Comida("Chilaquiles", "México", R.drawable.chilaquiles, R.drawable.mexico, "Platillo típico mexicano con totopos bañados en salsa verde o roja con una porcion de carne a la eleccion, acompañado con un poco de crema y queso."),
        Comida("Hamburguesa", "EE.UU.", R.drawable.hamburguesa, R.drawable.estados, "Clásica hamburguesa americana, con carne molida, cebolla, lechuga, mayonesa, ketchup, mostaza y queso."),
        Comida("Ramen", "Japón", R.drawable.ramen, R.drawable.japon, "Fideos japoneses en caldo, acompañados de 1 huevo, alga de mar,y trozos de cerdo aumado."),
        Comida("Paella", "España", R.drawable.paella, R.drawable.espana, "Platillo español con arroz y mariscos, aunque tambien puede ser acompañado con carnes como el cerdo o el res."),
        Comida("Pizza", "Italia", R.drawable.pizza, R.drawable.italia, "Pizza italiana con tomate y queso, la verdader pizza italiana."),
        Comida("Strogonov", "Rusia", R.drawable.strogonov, R.drawable.rusia, "Carne a la Stroganoff con crema, la carne con la que puede ser cocinada el strogonoff es desde el cerdo, pollo y res, llevando un acompañamiento de arroz y verduras"),
        Comida("Carnitas", "México", R.drawable.carnitas, R.drawable.mexico, "Cerdo cocido al estilo mexicano, en sus propias grasas en lenta coccion, sasonado con jugos y esencias de naranja, tomillo, laurel, etc, depenediendo de la region de donde se cocinen."),
        Comida("Fideos Wantong", "China", R.drawable.wantong, R.drawable.china, "Fideos chinos con wantong, estos tipos de fideos pueden ser comidos en frio o en caldo caliente, cuando se comen con caldo suelen ser acompañados con verduras y carne."),
        Comida("Cerdo Agridulce", "China", R.drawable.cerdo_agridulce, R.drawable.china, "Cerdo agridulce tradicional chino, cerdo en conjuncion y aromas que haran resaltar el paladar de hasta la morra mas chida."),
        Comida("Pollo Frito", "EE.UU.", R.drawable.pollo_frito, R.drawable.estados, "Clásico pollo frito, estilo americano, es un pollo empanizado con especias y despues puesto a freir durante 5 a 10 minutos dando asi el perfecto platillo colesterol.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listview)
        searchView = findViewById(R.id.searchView)

        // Configuramos el adaptador personalizado
        adapter = Adaptado(this, foodList)
        listView.adapter = adapter


        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = adapter.getItem(position)

            val intent = Intent(this, HolaActivity::class.java).apply {
                putExtra("nombre", selectedItem.name)
                putExtra("pais", selectedItem.country)
                putExtra("descripcion", selectedItem.description)
                putExtra("foodImage", selectedItem.foodImageResId)
                putExtra("countryImage", selectedItem.countryImageResId)
            }
            startActivity(intent)
        }
    }
}
