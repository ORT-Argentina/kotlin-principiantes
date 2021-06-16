package com.adb.bluetoothexample

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import app.akexorcist.bluetotohspp.library.BluetoothSPP
import app.akexorcist.bluetotohspp.library.BluetoothSPP.BluetoothConnectionListener
import app.akexorcist.bluetotohspp.library.BluetoothState
import app.akexorcist.bluetotohspp.library.DeviceList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var bt: BluetoothSPP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt = BluetoothSPP(this)

        bt.send("aaa", true);

        bt.setOnDataReceivedListener { data, message ->

            Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
        }

        if (!bt.isBluetoothEnabled) {
            val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(intent, BluetoothState.REQUEST_ENABLE_BT)
        } else {
            if (bt.isServiceAvailable) {
                bt.setupService()
                bt.startService(BluetoothState.DEVICE_ANDROID)
                // setup();
            }
        }

        btn_conectar.setOnClickListener(View.OnClickListener {
            if (bt.serviceState == BluetoothState.STATE_CONNECTED) {
                bt.disconnect()
            } else {
                val intent = Intent(applicationContext, DeviceList::class.java)
                startActivityForResult(intent, BluetoothState.REQUEST_CONNECT_DEVICE)
            }
        })

        bt.setBluetoothConnectionListener(object : BluetoothConnectionListener {
            override fun onDeviceConnected(name: String, address: String) {
                Toast.makeText(applicationContext
                        , "Connected to $name\n$address"
                        , Toast.LENGTH_SHORT).show()
            }

            override fun onDeviceDisconnected() {
                Toast.makeText(applicationContext
                        , "Connection lost", Toast.LENGTH_SHORT).show()
            }

            override fun onDeviceConnectionFailed() {
                Toast.makeText(applicationContext
                        , "Unable to connect", Toast.LENGTH_SHORT).show()
            }
        })
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == BluetoothState.REQUEST_CONNECT_DEVICE) {
            if (resultCode == Activity.RESULT_OK)
                bt.connect(data)
        } else if (requestCode == BluetoothState.REQUEST_ENABLE_BT) {
            if (resultCode == Activity.RESULT_OK) {
                bt.setupService()
                bt.startService(BluetoothState.DEVICE_ANDROID)
                //setup();
            } else {
                // Do something if user doesn't choose any device (Pressed back)
            }
        }
    }

}

