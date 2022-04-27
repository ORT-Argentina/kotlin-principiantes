package com.manadigital.recyclerview1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.entities.Contacto
import com.manadigital.recyclerview1.holders.ContactoHolder

class ContactoListAdapter(
    private var contactsList: MutableList<Contacto>,
    val onItemClick: (Int) -> Boolean
) : RecyclerView.Adapter<ContactoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_contactos,parent,false)
        return (ContactoHolder(view))
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    fun setData(newData: ArrayList<Contacto>) {
        this.contactsList = newData
        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ContactoHolder, position: Int) {

        holder.setName(contactsList[position].nombre)


        holder.getButton().setOnLongClickListener() {
                onItemClick(position)
        }

    }
}