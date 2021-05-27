package com.utn.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Fragment1ViewModel : ViewModel() {

    val name = MutableLiveData<String>()

    lateinit var texto : String

    fun changeName (){

        name.value = "pepe"
    }


}
