package com.utn.tabs.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2

import com.utn.tabs.R
import com.utn.tabs.adapters.ViewPagerAdapter2

/**
 * A simple [Fragment] subclass.
 */
class fragment3 : Fragment() {


    lateinit var v : View
    lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fragment3, container, false)
        viewPager = v.findViewById(R.id.view_pager2)
        return v
    }

    override fun onStart() {
        super.onStart()

        viewPager.setAdapter(ViewPagerAdapter2(requireActivity()))
    }

}
