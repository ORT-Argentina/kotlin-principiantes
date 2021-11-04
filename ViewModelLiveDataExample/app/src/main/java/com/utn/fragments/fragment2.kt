package com.utn.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

import com.utn.viewmodellivedataexample.R

class fragment2 : Fragment() {

    companion object {
        fun newInstance() = fragment2()
    }

    lateinit var v: View

    //private lateinit var viewModel2: Fragment2ViewModel
    private lateinit var viewModel1: Fragment1ViewModel

    lateinit var btnChange : Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.fragment2_fragment, container, false)

        btnChange = v.findViewById(R.id.btn_go)

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel2 = ViewModelProvider(requireActivity()).get(Fragment2ViewModel::class.java)
        viewModel1 = ViewModelProvider(requireActivity()).get(Fragment1ViewModel::class.java)

        // TODO: Use the ViewModel
    }

   /* override fun onStart() {
        super.onStart()

        btnChange.setOnClickListener {

            //viewModel1.name.value = "otro valor"

            v.findNavController().popBackStack()
        }
    }*/

}
