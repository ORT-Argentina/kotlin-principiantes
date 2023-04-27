package ar.edu.ort.tp3.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ar.edu.ort.tp3.myapplication.adapters.AlumnoListAdapter
import ar.edu.ort.tp3.myapplication.entities.Alumno


class FirstFragment : Fragment() {

    var listaAlumnos: MutableList<Alumno> = ArrayList<Alumno>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista = inflater.inflate(R.layout.fragment_first, container, false)

        vista.findViewById<Button>(R.id.btnFragmentFirstSetting).setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSettingsFragment()
            this.findNavController().navigate(action)
        }

        vista.findViewById<Button>(R.id.btnFirstFragmentGo).setOnClickListener {
            var alumno = Alumno("Juan", 30, Alumno.Constants.cursoA)
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(alumno)
            this.findNavController().navigate(action)
        }

        for(i in 1..1000){
            listaAlumnos.add(Alumno("Alumno $i", i, Alumno.Constants.cursoA))
        }

        val recyclerViewAlumnos = vista.findViewById<RecyclerView>(R.id.rec_alumnos)

        recyclerViewAlumnos.adapter = AlumnoListAdapter(listaAlumnos)
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerViewAlumnos.layoutManager = linearLayoutManager


        return vista
    }
}