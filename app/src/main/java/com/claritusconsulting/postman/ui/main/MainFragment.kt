package com.claritusconsulting.postman.ui.main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.claritusconsulting.postman.R
import com.claritusconsulting.postman.ui.adapters.PostPagerAdapter
import com.claritusconsulting.postman.ui.history.HistoryFragment
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_main, container, false)

        setupViewPager(main_pager)
        main_tabs.setupWithViewPager(main_pager)
        return view
    }

    private fun setupViewPager(main_pager: ViewPager?) {
        val postPagerAdapter = PostPagerAdapter(activity?.supportFragmentManager)
        val h1 = HistoryFragment.newInstance()
        postPagerAdapter.addFragment(h1,"History");
//        postPagerAdapter.addFragment(h1,"Collection")
        main_pager?.adapter = postPagerAdapter
    }
}
