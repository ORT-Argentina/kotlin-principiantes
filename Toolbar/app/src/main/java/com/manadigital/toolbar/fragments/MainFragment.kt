package com.manadigital.toolbar.fragments

import android.icu.text.CaseMap
import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar


import com.manadigital.toolbar.R



class MainFragment : Fragment() {
    
    lateinit var v:View
    lateinit var btnNavigate: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment



        v =  inflater.inflate(R.layout.fragment_main, container, false)
        btnNavigate = v.findViewById(R.id.btnNavigate)

        setHasOptionsMenu(true)

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnNavigate.setOnClickListener {
            var action = MainFragmentDirections.actionMainFragmentToBlankFragment()
            v.findNavController().navigate(action)
        }

    }

    override fun onStart() {
        super.onStart()
        requireActivity().setTitle("Main Fragment")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_toolbar, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

   override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val id = when(item.itemId) {

            R.id.action_add -> Snackbar.make(v, "Action to Add", Snackbar.LENGTH_SHORT).show()

            R.id.action_fav -> Snackbar.make(v, "Action to Fav", Snackbar.LENGTH_SHORT).show()

            R.id.test -> Snackbar.make(v, "Click Test", Snackbar.LENGTH_LONG).show()

            else -> Snackbar.make(v, "else", Snackbar.LENGTH_SHORT).show()

            //else -> ""
        }

        return super.onOptionsItemSelected(item)
   }
}
