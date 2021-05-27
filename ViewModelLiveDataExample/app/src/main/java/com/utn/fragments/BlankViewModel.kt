package com.utn.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlankViewModel : ViewModel() {

    private var user: MutableLiveData<String>? = null

    private var password: MutableLiveData<String>? = null

    fun getUser(): MutableLiveData<String>? {
        if (user == null) {
            user = MutableLiveData()
        }
        return user
    }

    fun getPassword(): MutableLiveData<String>? {
        if (password == null) {
            password = MutableLiveData()
        }
        return password
    }

}