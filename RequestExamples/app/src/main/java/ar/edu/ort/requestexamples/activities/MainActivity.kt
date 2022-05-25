package ar.edu.ort.requestexamples.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import ar.edu.ort.requestexamples.R
import ar.edu.ort.requestexamples.api.MarvelService
import ar.edu.ort.requestexamples.data.CharacterResponse
import ar.edu.ort.requestexamples.data.MarvelResponse
import ar.edu.ort.requestexamples.entities.MarvelHereo
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)

        val baseURL = getString(R.string.request_url_sample)
        val apiKey = getString(R.string.api_key)
        val hash = getString(R.string.hash)

        //Create Service
        val api = MarvelService.create(baseURL)

        //Call Request
        api.getCharacters(apiKey, hash)?.enqueue(object : Callback<MarvelResponse<CharacterResponse?>?> {
            override fun onResponse(
                call: Call<MarvelResponse<CharacterResponse?>?>,
                response: Response<MarvelResponse<CharacterResponse?>?>
            ) {
                val response: MarvelResponse<CharacterResponse?>? = (response.body() as MarvelResponse<CharacterResponse?>)!!

                val characters: MutableList<MarvelHereo>? = response?.data?.results?.toMutableList()

                val heroes = arrayOfNulls<String>(characters?.size ?: 0)

                if (characters != null) {
                    for (i in characters.indices) {
                        heroes[i] = characters[i].name
                    }
                }

                listView.adapter = ArrayAdapter(
                    applicationContext,
                    android.R.layout.simple_list_item_1,
                    heroes
                )
            }

            override fun onFailure(call: Call<MarvelResponse<CharacterResponse?>?>, t: Throwable) {
                Snackbar.make(findViewById(R.id.listView), t.message.toString(), Snackbar.LENGTH_LONG).show()
            }
        })
    }
}