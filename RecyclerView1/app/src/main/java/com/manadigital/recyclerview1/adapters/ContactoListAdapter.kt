package com.manadigital.recyclerview1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.entities.Contacto
import com.manadigital.recyclerview1.holders.ContactoHolder

class ContactoListAdapter(
    private var contactsList: MutableList<Contacto>/*,
    val onItemClick: (Int) -> Boolean*/

) : RecyclerView.Adapter<ContactoHolder>() {
//class MascotaListAdapter (private var mascotasList: MutableList<Mascota>) : RecyclerView.Adapter<MascotaListAdapter.MascotaHolder>() {

    companion object {

        private val TAG = "ContactoListAdapter"
    }

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

//        Glide
//            .with(context)
//            .load("https://firebasestorage.googleapis.com/v0/b/firestoreexample-ec489.appspot.com/o/Fotos%2FGUERNICA.jpg?alt=media&token=001a8ffc-96c2-4aeb-9120-8d5099b3fa1c")
//
//            .centerInside()
//            .into(holder.getImageView());
//
        /*    holder.getCardLayout().setOnLongClickListener() {
                onItemClick(position)
            }*/

    }
}