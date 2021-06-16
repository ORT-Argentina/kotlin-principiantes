package com.adb.firebaseexample.fragments

import androidx.lifecycle.ViewModel
import com.manadigital.recyclerview1.entities.Mascota

class ListViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var mascotas : MutableList<Mascota> = ArrayList<Mascota>()

    fun initTestList ()
    {
        mascotas.add(Mascota("Pedro",Mascota.Constants.typePerro,"Colie",3,"mascotas.com"))
        mascotas.add(Mascota("Rodolgo",Mascota.Constants.typePerro,"Fox Terrier",4,"mascotas.com"))
        mascotas.add(Mascota("Emilio",Mascota.Constants.typePerro,"Gran Danes",5,"mascotas.com"))
        mascotas.add(Mascota("Luis",Mascota.Constants.typeGato,"Siames",6,"mascotas.com"))
        mascotas.add(Mascota("Carlos",Mascota.Constants.typeGato,"Pardo",7,"mascotas.com"))
        mascotas.add(Mascota("David",Mascota.Constants.typeGato,"Arlequin",8,"mascotas.com"))
    }


}
