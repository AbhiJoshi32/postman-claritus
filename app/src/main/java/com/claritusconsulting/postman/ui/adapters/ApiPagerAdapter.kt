package com.claritusconsulting.postman.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter


class ApiPagerAdapter(fragmentManager: FragmentManager?) :
        FragmentStatePagerAdapter(fragmentManager) {
    val fragments:ArrayList<Fragment> = ArrayList()
    val titles:ArrayList<String> = ArrayList()
    override fun getItem(position: Int): Fragment = fragments.get(position)

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? = titles.get(position)

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        titles.add(title)
    }
}