package com.ort.edu.challengepractica.fragments

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.ort.edu.challengepractica.R
import com.ort.edu.challengepractica.UserSession


/**
 * A simple [Fragment] subclass.
 * Use the [SettingsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SettingsFragment : Fragment() {

    private lateinit var avatarImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        avatarImage = view.findViewById(R.id.avatar_image)

        val nameText = view.findViewById<TextView>(R.id.nameText)
        val passwordText = view.findViewById<TextView>(R.id.password_text)

        // Lo que hace esto es mostrar un subrayado para los TextView
        nameText.paintFlags = nameText.paintFlags or Paint.UNDERLINE_TEXT_FLAG
        passwordText.paintFlags = passwordText.paintFlags or Paint.UNDERLINE_TEXT_FLAG

        nameText.text = UserSession.userName

        // Cargo la imagen hardcodeada del avatar para la imagen. Como uso .circleCrop() entonces va a aparecer de forma
        // redondeada en lugar de cuadrada como lo haria por default
        Glide.with(this)
            .load("https://www.w3schools.com/howto/img_avatar.png")
            .circleCrop()
            .into(avatarImage)
    }
}