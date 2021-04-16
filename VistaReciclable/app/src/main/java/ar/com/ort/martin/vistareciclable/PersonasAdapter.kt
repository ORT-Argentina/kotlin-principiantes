package ar.com.ort.martin.vistareciclable


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonasAdapter(
    private var listaPeronas: MutableList<Persona>
) : RecyclerView.Adapter<PersonasAdapter.PersonaHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_personas,parent, false)
        return (PersonaHolder(view))
    }

    override fun onBindViewHolder(holder: PersonaHolder, position: Int) {
        holder.setNombre(listaPeronas[position].nombre)
    }

    override fun getItemCount() =  listaPeronas.size

    class PersonaHolder ( v: View) : RecyclerView.ViewHolder(v){

        private var vista : View

        init{
            this.vista = v
        }

        fun setNombre(name: String){
            val txtNombreView: TextView = vista.findViewById(R.id.txt_nombre)
            txtNombreView.text = name
        }


    }

}