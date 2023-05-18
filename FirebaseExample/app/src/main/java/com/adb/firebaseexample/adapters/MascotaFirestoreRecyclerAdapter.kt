package com.adb.firebaseexample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.adb.firebaseexample.R
import com.adb.firebaseexample.holders.MascotaHolder
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.manadigital.recyclerview1.entities.Mascota


class MascotaFirestoreRecyclerAdapter(private val options: FirestoreRecyclerOptions<Mascota>) :
    FirestoreRecyclerAdapter<Mascota, MascotaHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mascota, parent, false)
        return MascotaHolder(view)
    }

    override fun onBindViewHolder(holder: MascotaHolder, position: Int, model: Mascota) {
        holder.setName(model.nombre)
    }
}