package ar.edu.ort.superheroapi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.navArgs
import ar.edu.ort.superheroapi.fragments.BlankFragment2


class MenuActivity : AppCompatActivity() {

    val args: MenuActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    override fun onStart() {
        super.onStart()


        val bundle = Bundle()
        bundle.putString("param", args.param)
        val fragInfo = BlankFragment2()
        fragInfo.setArguments(bundle)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView2, fragInfo)
            .commit()
    }
}