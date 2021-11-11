package com.utn.coroutinesexample.fragments

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar

import com.utn.coroutinesexample.R
import kotlinx.coroutines.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    lateinit var v: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.main_fragment, container, false)
        return v;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()

        val parentJob = Job()
        val scope = CoroutineScope(Dispatchers.Default + parentJob)

        //scope.launch {
            task1(v)
            task2(v)
            task3(v)
        //}

        task4(v)

        scope.launch {
            val one = async { fetchDataFromServerOne() }
            val two = async { fetchDataFromServerTwo() }
            Log.d("Test", "The sum is ${one.await() + two.await()}")
        }

//        scope.launch {
//            task1()
//        }
//        scope.launch {
//            task2()
//        }
//        scope.launch {
//            task3()
//        }



    }

}


suspend fun task1 (v:View){

    delay(3000);
    Log.d("Test","tarea1")
    Snackbar.make(v,"tarea1", Snackbar.LENGTH_SHORT).show()
}

suspend fun task2 (v:View){

    delay(5000);
    Log.d("Test","tarea2")
    Snackbar.make(v,"tarea2", Snackbar.LENGTH_SHORT).show()
}

suspend fun task3 (v:View){

    delay(7000);
    Log.d("Test","tarea3")
    Snackbar.make(v,"tarea3", Snackbar.LENGTH_SHORT).show()
}

 fun task4 (v:View){
     Log.d("Test","tarea4")
     Snackbar.make(v,"tarea3", Snackbar.LENGTH_SHORT).show()
}

private suspend fun fetchDataFromServerOne(): Int {
    Log.d("Test", "fetchDataFromServerOne()")
    delay(1000)
    return 1
}

private suspend fun fetchDataFromServerTwo(): Int {
    Log.d("Test", "fetchDataFromServerTwo()")
    delay(1000)
    return 2
}
