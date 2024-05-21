package com.manadigital.toolbar.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.manadigital.toolbar.R



/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //requireActivity().invalidateOptionsMenu()

        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.prueba, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    /*override fun onPrepareOptionsMenu(menu: Menu){
        super.onPrepareOptionsMenu(menu)
        val item = menu.findItem(R.id.action_done)
        item.isVisible = isEditing
    }*/
}