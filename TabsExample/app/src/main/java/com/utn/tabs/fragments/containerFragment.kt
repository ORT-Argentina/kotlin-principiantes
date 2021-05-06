package com.utn.tabs.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
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

        return v
    }

    override fun onStart() {
        super.onStart()

        viewPager.setAdapter(ViewPagerAdapter(requireActivity()))
        TabLayoutMediator(tabLayout, viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> tab.text = "Tab #1"
                    1 -> tab.text = "Tab #2"
                    2 -> tab.text = "Tab #3"
                    else -> tab.text = "undefined"
                }
            }).attach()
    }

}