package com.manadigital.recyclerview1.holders

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.R

class ContactoHolder (v: View) : RecyclerView.ViewHolder(v) {

    private var view: View

    init {
        this.view = v
    }

    fun setName(name: String) {
        val txt: TextView = view.findViewById(R.id.txt_name_item)
        txt.text = name
    }

    fun getCardLayout (): CardView {
        return view.findViewById(R.id.card_package_item)
    }

//
//        fun getImageView () : ImageView {
//            return view.findViewById(R.id.img_item)
//        }
}