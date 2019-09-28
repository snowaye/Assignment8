@file:Suppress("DEPRECATION")

package com.padc.batch9.assignment8.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.padc.batch9.assignment8.fragment.CinemaFragment
import com.padc.batch9.assignment8.fragment.ComingSoonFragment
import com.padc.batch9.assignment8.fragment.NowShowingFragment

class MyViewPagerAdapter(val fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager){


    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = NowShowingFragment()
            1 -> fragment = CinemaFragment()
            2 -> fragment = ComingSoonFragment()
        }

        return fragment!!

    }


    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var titel:String? = null
        when (position) {
            0 ->titel = "Now Showing"
            1 ->titel = "Cinema"
            2 ->titel = "Coming Soon"
        }
        return titel
    }
}