package com.adb.firebaseexample.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adb.firebaseexample.R
import com.adb.firebaseexample.adapters.MascotaFirestoreRecyclerAdapter
import com.adb.firebaseexample.entities.Contacto
import com.adb.firebaseexample.holders.MascotaHolder
import com.adb.firebaseexample.viewmodels.ListViewModel
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.manadigital.recyclerview1.entities.Mascota


class ListFragment : Fragment() {

    private lateinit var adapter: FirestoreRecyclerAdapter<Mascota, MascotaHolder>
    private lateinit var viewModel: ListViewModel

    lateinit var v: View
    lateinit var btnAdd : FloatingActionButton
    lateinit var recMascotas : RecyclerView
    lateinit var txtCollection : TextView

    var mascotaList : MutableList<Mascota> = arrayListOf()

    val db = Firebase.firestore

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        /*val settings = firestoreSettings {
            isPersistenceEnabled = false
        }
        db.firestoreSettings = settings*/

        checkRecords()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        v =  inflater.inflate(R.layout.list_fragment, container, false)
        btnAdd = v.findViewById(R.id.btn_add)
        recMascotas = v.findViewById(R.id.rec_mascotas)
        txtCollection =  v.findViewById(R.id.txtCollection)
        prepareFragment()

        return v
    }

    private fun prepareFragment(){
        recMascotas.setHasFixedSize(true)
        recMascotas.layoutManager = LinearLayoutManager(context)

        btnAdd.setOnClickListener(View.OnClickListener {
            val nuevaMascota = Mascota("Ort",Mascota.Constants.typePerro,"Sabueso",10,"mascotas.com")
            val contactoNuevo = Contacto("Martin", 10, Contacto.Constants.cursoA, "https://www.google.com/xxxxx.png")
            db.collection("mascotas").document().set(contactoNuevo)
            //db.collection("mascotas").document(nuevaMascota.nombre).set(nuevaMascota)
        })
    }

    override fun onStart() {
        super.onStart()

        fillRecycler()

        //var docRef = db.collection("mascotas").document("Pedro")

        /*docRef.get()
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
*/
        //traer lista de datos
        /*db.collection("mascotas")
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
            }*/
    }

    fun fillRecycler() {
        val rootRef = FirebaseFirestore.getInstance()

        val query = rootRef.collection("mascotas").orderBy("nombre")

        val options = FirestoreRecyclerOptions.Builder<Mascota>()
            .setQuery(query, Mascota::class.java)
            .build()

        val adapter = MascotaFirestoreRecyclerAdapter(options)

        adapter.startListening()
        recMascotas.adapter = adapter
    }

    fun checkRecords(){

        //db.collection("mascotas").document().set(Contacto("Pedro",26, Contacto.Constants.cursoA, ""))

        db.collection("mascotas").get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {

                    if(task.result!!.count() == 0){
                        viewModel.initTestList()

                        for (mascota in viewModel.mascotas) {
                            db.collection("mascotas").document().set(mascota)
                        }
                    }

                } else {
                    Log.d(TAG, "No se encontro la coleccion.", task.exception)
                }
            }
    }


}


