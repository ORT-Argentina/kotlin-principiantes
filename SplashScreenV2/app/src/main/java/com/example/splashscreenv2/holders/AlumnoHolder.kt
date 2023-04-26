package com.example.splashscreenv2.holders

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.splashscreenv2.R


class AlumnoHolder( v: View) : RecyclerView.ViewHolder(v) {

    private var view: View

    init {
        this.view = v
    }

    fun setName(name: String) {
        val txt = this.view.findViewById<TextView>(R.id.txtItemViewName)
        txt.text = name
    }

    fun getContainer(): CardView {
        return this.view.findViewById<CardView>(R.id.frameLayout)
    }

}
