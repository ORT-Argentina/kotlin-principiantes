package com.utn.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.utn.model.viewmodel.Fragment1ViewModel

import com.utn.viewmodellivedataexample.R

class Fragment2 : Fragment() {

    companion object {
        fun newInstance() = Fragment2()
    }

    lateinit var v: View

    //private lateinit var viewModel2: Fragment2ViewModel
    private lateinit var viewModel1: Fragment1ViewModel

    lateinit var btnChange : Button
    lateinit var txtNewText : EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.fragment2_fragment, container, false)

        btnChange = v.findViewById(R.id.btn_go)
        txtNewText = v.findViewById(R.id.txt_new_text)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel1 = ViewModelProvider(requireActivity()).get(Fragment1ViewModel::class.java)

        requireActivity().title = viewModel1.name.value.toString()
        txtNewText.setText(viewModel1.name.value.toString())
    }

   override fun onStart() {
       super.onStart()

       /*txtNewText.doOnTextChanged{ text, _, _, _ ->
           viewModel1.name.value = text.toString()
       }*/

       btnChange.setOnClickListener {
            viewModel1.name.value = txtNewText.text.toString()
            val action2 = Fragment2Directions.actionFragment2ToFragment1()
            v.findNavController().navigate(action2)
       }
    }

}
