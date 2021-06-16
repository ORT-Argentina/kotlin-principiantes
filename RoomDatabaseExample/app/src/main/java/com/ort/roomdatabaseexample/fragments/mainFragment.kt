package com.ort.roomdatabaseexample.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ort.roomdatabaseexample.R
import com.ort.roomdatabaseexample.database.appDatabase
import com.ort.roomdatabaseexample.database.userDao
import com.ort.roomdatabaseexample.entities.User
import com.wajahatkarim3.roomexplorer.RoomExplorer


class mainFragment : Fragment() {

    lateinit var v : View

    private var db: appDatabase? = null
    private var userDao: userDao? = null

    lateinit var edtName : EditText
    lateinit var edtEmail : EditText

    lateinit var btnAdd : Button
    lateinit var btnDelete : Button
    lateinit var btnEdit : Button
    lateinit var btnSearch : Button
    lateinit var btnDebug : Button
    lateinit var userList :MutableList<User>


    var i : Int =0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_main, container, false)

        edtName = v.findViewById(R.id.edt_name)
        edtEmail = v.findViewById(R.id.edt_email)

        btnAdd = v.findViewById(R.id.btn_add)
        btnDelete = v.findViewById(R.id.btn_delete)
        btnEdit = v.findViewById(R.id.btn_editar)
        btnSearch = v.findViewById(R.id.btn_search)
        btnDebug = v.findViewById(R.id.btn_debug)


        return v
    }


    override fun onStart() {
        super.onStart()

        db = appDatabase.getAppDataBase(v.context)
        userDao = db?.userDao()

        btnAdd.setOnClickListener {


            userDao?.insertPerson(User(i, edtName.text.toString(), edtEmail.text.toString()))
            i += 1
        }

        btnDelete.setOnClickListener {

            userDao?.delete(User(0, "", ""))
        }

        btnEdit.setOnClickListener {

            userDao?.updatePerson(User(0, "Juan", "juan@utn.com"))
        }

        btnSearch.setOnClickListener {

            Log.d("Test", userDao?.loadPersonById(0)?.name.toString())

            userList = userDao?.loadAllPersons() as MutableList<User>

            for ( actualUser in userList){
                Log.d("Test", actualUser.name)
        }

        }

        btnDebug.setOnClickListener {
            RoomExplorer.show(context, appDatabase::class.java, "myDB")

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }
}
