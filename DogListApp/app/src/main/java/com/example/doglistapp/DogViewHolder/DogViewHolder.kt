package com.example.doglistapp.DogViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.doglistapp.databinding.ItemDogBinding
import com.squareup.picasso.Picasso

class DogViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private var binding = ItemDogBinding.bind(view)

    fun bind(image: String ) {
        Picasso.get().load(image).into(binding.dogImage)
    }
}