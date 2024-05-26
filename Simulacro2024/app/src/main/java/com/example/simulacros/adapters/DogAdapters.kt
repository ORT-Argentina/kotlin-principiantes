package com.example.simulacros.adapters

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simulacros.R
import com.example.simulacros.domain.model.Dog
import com.example.simulacros.holders.DogHolder
import com.example.simulacros.listener.OnViewItemClickedListener

class DogListAdapter(
    private val dogList: List<Dog>,
    private val onItemClick: OnViewItemClickedListener
) : RecyclerView.Adapter<DogHolder>() {

    override fun getItemCount() = dogList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_dog,parent,false)
        return (DogHolder(view))
    }

    override fun onBindViewHolder(holder: DogHolder, position: Int) {

        val dog = dogList[position]

        holder.setName(TextUtils.concat(dog.name, " (", dog.age.toString(), ")").toString())
        holder.setCurso(dog.breed)
        holder.setOrden(position)

        Glide.with(holder.itemView.context)
            .load(dog.image)
            .centerCrop()
            .placeholder(R.drawable.progress_animation)
            .into(holder.getImage());

        holder.getCardLayout().setOnClickListener{
            onItemClick.onViewItemDetail(dog)
        }
    }


}