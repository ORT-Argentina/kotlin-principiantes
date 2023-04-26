package com.example.splashscreenv2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.splashscreenv2.R
import com.example.splashscreenv2.adapters.AlumnoListAdapter
import com.example.splashscreenv2.entities.Alumno

class ListFragment : Fragment() {

    lateinit var vista: View
    var alumnosList: MutableList<Alumno> = ArrayList<Alumno>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_list, container, false)

        for(i in 1 .. 50){
            alumnosList.add(Alumno("Nombre $i", 18+i, Alumno.Constants.cursoA))
        }

        val rec_alumnos = vista.findViewById<RecyclerView>(R.id.rec_alumnos)

        //rec_alumnos.setHasFixedSize(true)

        val linearLayoutManager = LinearLayoutManager(context)


        rec_alumnos.layoutManager = linearLayoutManager
        rec_alumnos.adapter = AlumnoListAdapter(alumnosList)



        return vista;
    }


}