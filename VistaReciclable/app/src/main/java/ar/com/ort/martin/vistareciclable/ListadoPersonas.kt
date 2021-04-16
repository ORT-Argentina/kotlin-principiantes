package ar.com.ort.martin.vistareciclable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListadoPersonas : Fragment() {

    lateinit var v: View

    lateinit var viewRecListadoPersonas: RecyclerView

    var personas : MutableList<Persona> = ArrayList<Persona>()


    companion object {
        fun newInstance() = ListadoPersonas().apply {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_listado_personas, container, false)
        viewRecListadoPersonas = v.findViewById(R.id.rev_personas)
        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onStart(){

        super.onStart();

        for(i in 1..10) {
            personas.add(Persona("Persona $i"))
        }

        viewRecListadoPersonas.setHasFixedSize(true);
        viewRecListadoPersonas.layoutManager = LinearLayoutManager(context)
        viewRecListadoPersonas.adapter = PersonasAdapter(personas)

    }

}