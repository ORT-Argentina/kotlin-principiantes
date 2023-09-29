package com.example.doglistapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.doglistapp.DogViewHolder.DogViewHolder
import com.example.doglistapp.R

class DogAdapter(private val images: List<String> ): RecyclerView.Adapter<DogViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DogViewHolder(layoutInflater.inflate(R.layout.item_dog, parent, false))
    }

    override fun getItemCount(): Int  = images.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        var item = images[position]
        holder.bind(item)
    }
}