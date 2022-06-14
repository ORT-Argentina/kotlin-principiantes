package ar.edu.ort.placeautocomplete

//import com.google.android.libraries.places.api.Places

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!Places.isInitialized()) {
            Places.initialize(applicationContext, "AIzaSyDcmuX27tGfel6OYDsBoZ65WavbgZylzfw")
        }

        //val placesClient = Places.createClient(this)

        val autocompleteFragment =
            supportFragmentManager.findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment?

        autocompleteFragment!!.setPlaceFields(
            Arrays.asList(
                Place.Field.ID,
                Place.Field.NAME,
                Place.Field.LAT_LNG
            )
        )

        // Set up a PlaceSelectionListener to handle the response.
        /*autocompleteFragment!!.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                // TODO: Get info about the selected place.
                val dest = place.latLng
                //mMap.addMarker(MarkerOptions().position(dest).title("Destination"))
                Log.i("placeautocomplete", "Place: " + place.getName() + ", " + place.getId());
            }

            /*override fun onError(status: Status?) {
                // TODO: Handle the error.
                Log.i("placeautocomplete", "An error occurred: " + status);
            }*/
        })*/

    /*
        val autocompleteFragment =
            supportFragmentManager.findFragmentById(R.id.autocomplete_fragment) as AutocompleteSupportFragment?
            */

    }
}