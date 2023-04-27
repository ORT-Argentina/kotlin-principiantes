package ar.edu.ort.tp3.myapplication.holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tp3.myapplication.R

class AlumnoViewHolder( v: View): RecyclerView.ViewHolder(v) {

    private var view: View

    init {
        this.view = v
    }

    fun setNombre(nombre: String) {
        val txt = this.view.findViewById<TextView>(R.id.txtHolderRCNombre)
        txt.text = nombre
    }

    fun setCurso(curso: String) {
        val txt = this.view.findViewById<TextView>(R.id.txtHolderRCCurso)
        txt.text = curso
    }

    fun getContainer(): View {
        return this.view.findViewById<View>(R.id.cardViewLayout)
    }

}
