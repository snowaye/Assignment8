@file:Suppress("DEPRECATION")

package com.padc.batch9.assignment8.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyViewPagerAdapter(val fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager){

    val mFragmentList:List<Fragment> = ArrayList<Fragment>()
    val mFragmentTitleList:List<String> = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.toMutableList().add(fragment)
        mFragmentTitleList.toMutableList().add(title)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }
}