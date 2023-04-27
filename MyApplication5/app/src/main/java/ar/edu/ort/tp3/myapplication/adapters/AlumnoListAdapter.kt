package ar.edu.ort.tp3.myapplication.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tp3.myapplication.R
import ar.edu.ort.tp3.myapplication.entities.Alumno
import ar.edu.ort.tp3.myapplication.holders.AlumnoViewHolder

class AlumnoListAdapter(
    private val alumnosList: MutableList<Alumno>
) : RecyclerView.Adapter<AlumnoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.alumno_item_view, parent, false)
        return AlumnoViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlumnoViewHolder, position: Int) {
        val alumno = alumnosList[position]
        holder.setNombre(alumno.nombre)
        holder.setCurso(alumno.curso)
    }

    override fun getItemCount(): Int {
        return alumnosList.size
    }

    /* mas Cheto*/
    //override fun getItemCount() = alumnosList.size

}