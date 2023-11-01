package com.dilah.muslim_media_app.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dilah.muslim_media_app.fragment.AboutAlQuranFragment
import com.dilah.muslim_media_app.fragment.AlJazeeraFragment
import com.dilah.muslim_media_app.fragment.CommonFragment
import com.dilah.muslim_media_app.fragment.WarningFragment

class SectionPagerAdapter (fa: FragmentActivity)
    : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CommonFragment()
            1 -> AboutAlQuranFragment()
            2 -> AlJazeeraFragment()
            3 -> WarningFragment()
            else -> AlJazeeraFragment()

        }
    }
}