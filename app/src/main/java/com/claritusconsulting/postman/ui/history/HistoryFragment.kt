package com.claritusconsulting.postman.ui.history


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.claritusconsulting.postman.R
import com.claritusconsulting.postman.data.ApiRequest
import com.claritusconsulting.postman.di.Injectable
import com.claritusconsulting.postman.ui.adapters.HistoryAdapter
import com.claritusconsulting.postman.ui.api.ApiFragment
import kotlinx.android.synthetic.main.fragment_history.view.*
import timber.log.Timber
import javax.inject.Inject

class HistoryFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var historyViewModel: HistoryViewModel
    val historyList = mutableListOf<ApiRequest>()
    lateinit var adapter: HistoryAdapter
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)
        adapter = HistoryAdapter(historyList,context) {
            val apiReqFragment = ApiFragment()
            val bundle = Bundle()
            bundle.putString("id",it.requestId.toString())
            apiReqFragment.arguments = bundle
            activity!!.supportFragmentManager.beginTransaction().add(R.id.main_frame,apiReqFragment).addToBackStack("main").commitAllowingStateLoss()
        }
        view.historyRecycler.layoutManager = LinearLayoutManager(context)
        view.historyRecycler.adapter = adapter
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        historyViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(HistoryViewModel::class.java)
        historyViewModel.getHistory().observe(this, Observer { reqList->
            historyList.clear()
            historyList.addAll(ArrayList(reqList))
            Timber.d(historyList.toString())
            adapter.notifyDataSetChanged()
        })
    }
}
