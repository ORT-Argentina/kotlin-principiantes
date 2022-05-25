package ar.edu.ort.requestexamples.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import ar.edu.ort.requestexamples.R
import ar.edu.ort.requestexamples.entities.Hero
import ar.edu.ort.requestexamples.interfaces.superheroAPI
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)

        var retrofit = Retrofit.Builder()
            .baseUrl(getString(R.string.request_url_sample))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(superheroAPI::class.java)

        api.getHeroes()?.enqueue(object : Callback<List<Hero?>?> {

            override fun onResponse(call: Call<List<Hero?>?>?,
                                    response: Response<List<Hero?>?>
            ) {
                val heroList: List<Hero> = (response.body() as List<Hero>?)!!

                val heroes = arrayOfNulls<String>(heroList.size)

                for (i in heroList.indices) {
                    heroes[i] = heroList[i].name
                }

                listView.setAdapter(
                    ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_list_item_1,
                        heroes
                    )
                )
            }

            override fun onFailure(call: Call<List<Hero?>?>?, t: Throwable) {
                Snackbar.make(findViewById(R.id.listView), t.message.toString(), Snackbar.LENGTH_LONG).show()
            }
        })
    }
}