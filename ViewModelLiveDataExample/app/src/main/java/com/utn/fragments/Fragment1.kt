package com.utn.fragments

import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.utn.model.viewmodel.Fragment1ViewModel
import com.utn.model.viewmodel.Fragment2ViewModel

import com.utn.viewmodellivedataexample.R

class Fragment1 : Fragment() {

    companion object {
        fun newInstance() = Fragment1()
    }

    lateinit var v: View

    private lateinit var viewModel: Fragment1ViewModel


    lateinit var btnChange : Button
    lateinit var txtCartel : TextView
    lateinit var ptInput : EditText

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        v = inflater.inflate(R.layout.fragment1_fragment, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(Fragment1ViewModel::class.java)

        viewModel.name.observe(viewLifecycleOwner, Observer { result ->
            txtCartel.text = result.toString()
        })

        viewModel.name.observe(viewLifecycleOwner, Observer { result ->
            txtCartel.text = result.toString()
        })

        btnChange = v.findViewById(R.id.btn_go)
        txtCartel = v.findViewById(R.id.txt_cartel)
        ptInput = v.findViewById(R.id.etInput)

        viewModel = ViewModelProvider(requireActivity()).get(Fragment1ViewModel::class.java)

        ptInput.addOnUnhandledKeyEventListener(View.OnUnhandledKeyEventListener { v, event ->

            viewModel.name.value = ptInput.text.toString()
            return@OnUnhandledKeyEventListener true
        })

        if( viewModel.name.value != null)
            ptInput.setText(viewModel.name.value);

        return v
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)


    }

    override fun onStart() {
        super.onStart()

        btnChange.setOnClickListener {
            val action2 = Fragment1Directions.actionFragment1ToFragment2();
            v.findNavController().navigate(action2)
        }
    }
}
