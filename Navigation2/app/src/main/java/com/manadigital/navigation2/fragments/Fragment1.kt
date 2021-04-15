package com.manadigital.navigation2.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar

import com.manadigital.navigation2.R
import com.manadigital.navigation2.fragments.Entities.User

/**
 * A simple [Fragment] subclass.
 */
class Fragment1 : Fragment() {

    lateinit var v: View
    lateinit var btnGoToFragment2: Button
    lateinit var txtEmail : EditText
    lateinit var txtPassword : EditText

    lateinit var user : User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_fragment1, container, false)

        btnGoToFragment2 = v.findViewById(R.id.btn_go_to_fragment2)
        txtEmail = v.findViewById(R.id.txtEmail);
        txtPassword = v.findViewById(R.id.txtPassword);
        // Inflate the layout for this fragment
        return v
    }


    override fun onStart() {
        super.onStart()
        //user = User ("martin.rivas@ort.edu.ar","123456")
        btnGoToFragment2.setOnClickListener {
            user = User(txtEmail.text.toString(), txtPassword.text.toString())
            if(
                user.email.toUpperCase() == "ADMIN"
                && user.password.toUpperCase() == "ADMIN" ) {

                val action = Fragment1Directions.actionFragment1ToFragment2(user, user.email)

                v.findNavController().navigate(action)
            }else{
                Snackbar.make(v,"Usuario o Constraseña incorrecto.", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}
