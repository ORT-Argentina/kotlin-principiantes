package com.manadigital.navigation1.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.navigation1.Entities.Contacto
import com.manadigital.navigation1.R
import com.manadigital.navigation1.holders.ContactoHolder

class ContactAdapter(
    private val contacts: MutableList<Contacto>
) : RecyclerView.Adapter<ContactoHolder>() {

    override fun getItemCount() = contacts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.contacto,parent,false)
        return (ContactoHolder(view))
    }

    override fun onBindViewHolder(holder: ContactoHolder, position: Int) {

        val contact = contacts[position]

        holder.setName(contact.nombre)
        holder.setTelefono(contact.telefono)
        holder.setEmail(contact.email)
        //holder.setAvatar(contact.avatar)

        /*holder.getCardLayout().setOnClickListener{
            onItemClick.onViewItemDetail(contact)
        }*/
    }

}