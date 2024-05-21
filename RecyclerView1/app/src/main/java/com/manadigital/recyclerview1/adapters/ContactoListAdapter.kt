package com.manadigital.recyclerview1.adapters

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.entities.Contacto
import com.manadigital.recyclerview1.holders.ContactoHolder
import com.manadigital.recyclerview1.listener.OnViewItemClickedListener

class ContactoListAdapter(
    private val contactsList: MutableList<Contacto>,
    private val onItemClick: OnViewItemClickedListener
) : RecyclerView.Adapter<ContactoHolder>() {

    override fun getItemCount() = contactsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_contactos,parent,false)
        return (ContactoHolder(view))
    }

    override fun onBindViewHolder(holder: ContactoHolder, position: Int) {

        val contact = contactsList[position]

        holder.setName(TextUtils.concat(contact.nombre, " (", contact.edad.toString(), ")").toString())
        holder.setCurso(contact.curso)
        holder.setOrden(position)

        holder.getCardLayout().setOnClickListener{
            onItemClick.onViewItemDetail(contact)
        }
    }


}

