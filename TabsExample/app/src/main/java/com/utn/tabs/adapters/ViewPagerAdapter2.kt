package com.utn.tabs.adapters

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.utn.tabs.fragments.fragment4
import com.utn.tabs.fragments.fragment5

class ViewPagerAdapter2(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): androidx.fragment.app.Fragment {
        return when (position) {
            0 -> fragment4()
            1 -> fragment5()
            else -> fragment4()
        }
    }
}