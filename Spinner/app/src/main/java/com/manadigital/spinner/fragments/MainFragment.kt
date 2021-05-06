package com.manadigital.spinner.fragments

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

import com.manadigital.spinner.R

class MainFragment : Fragment() {
    
    lateinit var v:View
    lateinit var spMeses : Spinner

     var listaMeses = listOf("enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        v =  inflater.inflate(R.layout.fragment_main, container, false)

        spMeses = v.findViewById(R.id.sp_months)

        setHasOptionsMenu(true)

        return v
    }

    override fun onStart() {
        super.onStart()

        populateSpinner(spMeses,listaMeses,context!!)

        spMeses.setSelection(0, false) // evita la primer falsa entrada si existe validación

        spMeses.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                Snackbar.make(v, listaMeses[position], Snackbar.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                Snackbar.make(v, "No hay nada seleccionado", Snackbar.LENGTH_SHORT).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = when(item.itemId) {

            R.id.action_add ->Snackbar.make(v, "add", Snackbar.LENGTH_SHORT).show()

            R.id.action_fav ->Snackbar.make(v, "fav", Snackbar.LENGTH_SHORT).show()

            else -> ""
        }
        return super.onOptionsItemSelected(item)
    }
}

/*
* Aux Functions
*
* */

fun populateSpinner (spinner: Spinner, list : List<String>, context : Context)
{
    //   val aa = ArrayAdapter( context!!, android.R.layout.simple_spinner_item, list)
    val aa = ArrayAdapter(context,android.R.layout.simple_spinner_item, list)

    // Set layout to use when the list of choices appear
    aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    // Set Adapter to Spinner
    spinner.setAdapter(aa)
}
