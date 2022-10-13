package com.ort.edu.challengepractica.adapter

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.ort.edu.challengepractica.R
import com.ort.edu.challengepractica.model.Product

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val description: TextView
    private val price: TextView
    private val image: ImageView

    init {
        description = itemView.findViewById(R.id.product_description_text)
        price = itemView.findViewById(R.id.product_price_text)
        image = itemView.findViewById(R.id.product_image)
    }

    fun bind(product: Product) {
        description.text = product.description
        price.text = "$${product.price}"

        Glide.with(itemView)
            .load(product.imageLink)
            .into(image)
    }
}