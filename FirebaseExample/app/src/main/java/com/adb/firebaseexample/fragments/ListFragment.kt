package com.adb.firebaseexample.fragments

import android.R.attr
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.adb.firebaseexample.R
import com.adb.firebaseexample.holders.MascotaHolder
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.manadigital.recyclerview1.entities.Mascota
import org.json.JSONException

import android.widget.Toast

import android.R.attr.tag

import org.json.JSONObject




class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListViewModel
    lateinit var v: View

    lateinit var btnAdd : FloatingActionButton
    lateinit var recMascotas : RecyclerView

    var mascotaList : MutableList<Mascota> = arrayListOf()

    private lateinit var adapter: FirestoreRecyclerAdapter<Mascota, MascotaHolder>


    // Access a Cloud Firestore instance from your Activity
     val db = Firebase.firestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v =  inflater.inflate(R.layout.list_fragment, container, false)
        btnAdd = v.findViewById(R.id.btn_add)

        recMascotas = v.findViewById(R.id.rec_mascotas)
        recMascotas.setHasFixedSize(true)
        recMascotas.layoutManager = LinearLayoutManager(context)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onStart() {
        super.onStart()


/*
        var mascota : Mascota = Mascota("Pedro",Mascota.Constants.typePerro,"Colie",2,"imagen.com")

        db.collection("mascotas").document(mascota.nombre).set(mascota)

        db.collection("mascotas").add(mascota)

        viewModel.initTestList()


        for (mascota in viewModel.mascotas) {
            db.collection("mascotas").document(mascota.nombre).set(mascota)
        }
*/
        // Leer datos una sola vez
        var docRef = db.collection("mascotas").document("Pedro")

        docRef.get()
            .addOnSuccessListener { dataSnapshot ->
                if (dataSnapshot != null) {
                    val mascota  = dataSnapshot.toObject<Mascota>()
                    Log.d("Test", "DocumentSnapshot data: ${mascota.toString()}")
                } else {
                    Log.d("Test", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d("Test", "get failed with ", exception)
            }

        // Se queda escuchando cambios
        docRef = db.collection("mascotas").document("Pedro")

        docRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                Log.w("Test", "Listen failed.", e)
                return@addSnapshotListener
            }

            if (snapshot != null && snapshot.exists()) {
                val mascota  = snapshot.toObject<Mascota>()
                Log.d("Test", "DocumentSnapshot data: ${mascota.toString()}")
            } else {
                Log.d("Test", "Current data: null")
            }
        }

        //traer lista de datos

        db.collection("mascotas")
             .whereEqualTo("tipo", "PERRO")
             .limit(20)
             .orderBy("edad")
            .get()
            .addOnSuccessListener { snapshot ->
                if (snapshot != null) {
                    for (mascota in snapshot) {
                        mascotaList.add(mascota.toObject())
                    }
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }

        fillRecycler()
    }

    fun fillRecycler() {
        val rootRef = FirebaseFirestore.getInstance()
        val query = rootRef.collection("mascotas")

        val options = FirestoreRecyclerOptions.Builder<Mascota>()
            .setQuery(query, Mascota::class.java)
            .build()

        adapter = object :
            FirestoreRecyclerAdapter<Mascota, MascotaHolder>(options) {

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_mascota, parent, false)
                return MascotaHolder(view)
            }

            override fun onBindViewHolder(holder: MascotaHolder, position: Int, model: Mascota) {
                holder.setName(model.nombre)
            }

            override fun onDataChanged() {
                super.onDataChanged()
            }
        }
        adapter.startListening()
        recMascotas.adapter = adapter
    }

    var req: JsonObjectRequest = object : JsonObjectRequest(Request.Method.GET, url,
        null, object : Listener<JSONObject?>() {
            fun onResponse(response: JSONObject) {
                Log.d(attr.tag, response.toString())
                activity.hideDialog()
                try {
                    activity.onRequestServed(response, code)
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
        }, object : ErrorListener() {
            fun onErrorResponse(error: VolleyError) {
                VolleyLog.d(attr.tag, "Error: " + error.getMessage())
                Log.e(attr.tag, "Site Info Error: " + error.getMessage())
                Toast.makeText(
                    activity!!.applicationContext,
                    error.getMessage(), Toast.LENGTH_SHORT
                ).show()
                activity.hideDialog()
                try {
                    activity.onRequestServed(null, code)
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }
        }) {//headers.put("Content-Type", "application/json");
        /**
         * Passing some request headers
         */
        @get:Throws(AuthFailureError::class)
        val headers: Map<String, String>?
            get() {
                val headers = HashMap<String, String>()
                //headers.put("Content-Type", "application/json");
                headers["key"] = "Value"
                return headers
            }
    }
}


