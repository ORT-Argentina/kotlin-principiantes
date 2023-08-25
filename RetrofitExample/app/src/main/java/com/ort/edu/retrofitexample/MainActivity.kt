package com.ort.edu.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.ort.edu.retrofitexample.model.Activity
import com.ort.edu.retrofitexample.model.PaginateResponse
import com.ort.edu.retrofitexample.model.Pokemon
import com.ort.edu.retrofitexample.service.ActivityServiceApiBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var activityText: TextView
    private lateinit var typeText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        activityText = findViewById(R.id.activity_text)
        typeText = findViewById(R.id.type_text)

        loadPokemon()


    }

    fun loadPokemon() {
        val service = ActivityServiceApiBuilder.create()

        service.getPokemon().enqueue(object : Callback<PaginateResponse<Pokemon>> {
            override fun onResponse(call: Call<PaginateResponse<Pokemon>>, response: Response<PaginateResponse<Pokemon>>) {

                if (response.isSuccessful) {
                    val responsePokemon = response.body()

                    activityText.text = responsePokemon?.count.toString()
                    typeText.text = responsePokemon?.results?.get(0)?.name.toString()
                }
            }

            override fun onFailure(call: Call<PaginateResponse<Pokemon>>, t: Throwable) {
                Log.e("Example", t.stackTraceToString())
            }
        })
    }

}