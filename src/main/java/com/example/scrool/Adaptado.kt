package com.example.scrool

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView

class Adaptado(private val context: Context, private var foodList: List<Comida>) : BaseAdapter(), Filterable {

    private var filteredFoodList: List<Comida> = foodList

    override fun getCount(): Int = filteredFoodList.size

    override fun getItem(position: Int): Comida = filteredFoodList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.listavista, parent, false)

        val foodImageView: ImageView = view.findViewById(R.id.foodImageView)
        val countryImageView: ImageView = view.findViewById(R.id.countryImageView)
        val nameTextView: TextView = view.findViewById(R.id.foodNameTextView)
        val countryTextView: TextView = view.findViewById(R.id.countryTextView)

        val foodItem = getItem(position)
        foodImageView.setImageResource(foodItem.foodImageResId)
        countryImageView.setImageResource(foodItem.countryImageResId)
        nameTextView.text = foodItem.name
        countryTextView.text = foodItem.country

        return view
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint?.toString()?.lowercase() ?: ""
                val filteredResults = if (query.isEmpty()) {
                    foodList
                } else {
                    foodList.filter {
                        it.name.lowercase().contains(query) || it.country.lowercase().contains(query)
                    }
                }

                return FilterResults().apply {
                    values = filteredResults
                }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredFoodList = results?.values as List<Comida>
                notifyDataSetChanged()
            }
        }
    }
}

