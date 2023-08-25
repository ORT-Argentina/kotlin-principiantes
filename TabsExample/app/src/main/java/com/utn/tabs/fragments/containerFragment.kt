package com.utn.tabs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.utn.tabs.R
import com.utn.tabs.adapters.ViewPagerAdapter


class containerFragment : Fragment() {

    lateinit var v: View
    lateinit var viewPager: ViewPager2
    lateinit var tabLayout: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        v = inflater.inflate(R.layout.fragment_container, container, false)

        tabLayout = v.findViewById(R.id.tab_layout)

        viewPager = v.findViewById(R.id.view_pager)

        //Inactiva el movimingo Swipping de los dedos, Unicamente por código
        //viewPager.isUserInputEnabled = false

        return v
    }

    override fun onStart() {
        super.onStart()

        viewPager.setAdapter(ViewPagerAdapter(requireActivity()))


        //Toast.makeText(requireActivity(), "Fragmento creado", Toast.LENGTH_SHORT).show()
        Snackbar.make(v, "Fragmento creado", Snackbar.LENGTH_SHORT).show()

        TabLayoutMediator(tabLayout, viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Tab1"
                    tab.setIcon(R.drawable.tabicon)
                }
                1 -> {
                    tab.text = "Tab2"
                    tab.orCreateBadge.isVisible = true
                    tab.orCreateBadge.number = 10
                }
                2 -> tab.text = "Tab3"
                3 -> tab.text = "Tab5"
                else -> tab.text = "undefined"
            }
        }).attach()
    }

}