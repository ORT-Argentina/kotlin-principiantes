package com.manadigital.recyclerview1.fragments

import android.util.Log
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

import com.manadigital.recyclerview1.R
import com.manadigital.recyclerview1.entities.Contacto
import com.manadigital.recyclerview1.adapters.ContactoListAdapter
import com.manadigital.recyclerview1.listener.OnViewItemClickedListener

class listFragment : Fragment(), OnViewItemClickedListener {

    lateinit var vista: View

    lateinit var recContactos : RecyclerView

    var contactos : MutableList<Contacto> = ArrayList()

    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var contactoListAdapter: ContactoListAdapter

    companion object {
        fun newInstance() = listFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        vista =  inflater.inflate(R.layout.list_fragment, container, false)

        recContactos = vista.findViewById(R.id.rec_contactos)

        Log.d("ListFragment", "onCreateView")

        return vista
    }


    override fun onStart() {
        super.onStart()
        Log.d("ListFragment", "onResume")
        //Creo la Lista Dinamica
            for (i in 1..100) {
            contactos.add(Contacto("Pedro",26, Contacto.Constants.cursoA, ""))
            contactos.add(Contacto("Rodolfo",30, Contacto.Constants.cursoA, ""))
            contactos.add(Contacto("Emilio",28, Contacto.Constants.cursoB, ""))
            contactos.add(Contacto("Luis",37, Contacto.Constants.cursoB, ""))
            contactos.add(Contacto("Carlos", 42, Contacto.Constants.cursoC, ""))
            contactos.add(Contacto("David",21, Contacto.Constants.cursoC, ""))
        }

        //Configuración Obligatoria
        requireActivity()

        recContactos.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        contactoListAdapter = ContactoListAdapter(contactos, this)

        recContactos.layoutManager = linearLayoutManager
        recContactos.adapter = contactoListAdapter
    }

    override fun onResume() {
        super.onResume()
        Log.d("ListFragment", "onResume")
    }

    override fun onViewItemDetail(contacto: Contacto) {
        val action = listFragmentDirections.actionListFragmentToViewItem(contacto)
        this.findNavController().navigate(action)
        //findNavController().navigate(action)
        //Snackbar.make(v,contacto.nombre,Snackbar.LENGTH_SHORT).show()
    }
}
