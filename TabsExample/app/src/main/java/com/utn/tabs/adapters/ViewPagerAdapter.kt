package com.utn.tabs.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.utn.tabs.fragments.fragment1
import com.utn.tabs.fragments.fragment2
import com.utn.tabs.fragments.fragment3

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {

        return when(position){
            0 -> fragment1()
            1 -> fragment2()
            2 -> fragment3()

            else -> fragment1()
        }
    }

    override fun getItemCount(): Int {
        return TAB_COUNT
    }

    companion object {
        private const val TAB_COUNT = 3
    }
}