package com.ort.edu.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.ort.edu.retrofitexample.model.Activity
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

        getActivity()
    }

    fun getActivity() {
        val service = ActivityServiceApiBuilder.create()

        service.getActivity("1234_key").enqueue(object : Callback<Activity> {
            override fun onResponse(call: Call<Activity>, response: Response<Activity>) {
                if (response.isSuccessful) {
                    val activity = response.body()

                    activityText.text = activity?.name ?: "Activity no encontrada"
                    typeText.text = activity?.type ?: "Type no encontrado"
                }
            }

            override fun onFailure(call: Call<Activity>, t: Throwable) {
                Log.e("Example", t.stackTraceToString())
            }
        })
    }

}