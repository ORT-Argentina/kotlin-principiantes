package com.example.splashscreenv2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.splashscreenv2.R
import com.example.splashscreenv2.entities.Alumno
import com.example.splashscreenv2.holders.AlumnoHolder

class AlumnoListAdapter(
    private val alumnosList: MutableList<Alumno>
) : RecyclerView.Adapter<AlumnoHolder>()
{
    override fun getItemCount() = alumnosList.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_view,parent,false)
        return AlumnoHolder(view)
    }

    override fun onBindViewHolder(holder: AlumnoHolder, position: Int) {
        val alumno = alumnosList[position]
        holder.setName(alumno.nombre)
    }
}


