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
import com.claritusconsulting.postman.data.Request
import com.claritusconsulting.postman.di.Injectable
import com.claritusconsulting.postman.ui.adapters.HistoryAdapter
import kotlinx.android.synthetic.main.fragment_history.view.*
import timber.log.Timber
import javax.inject.Inject

class HistoryFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var historyViewModel: HistoryViewModel
    val historyList = mutableListOf<Request>()
    lateinit var adapter: HistoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)
        adapter = HistoryAdapter(historyList,context)
        view.historyRecycler.layoutManager = LinearLayoutManager(context)
        view.historyRecycler.adapter = adapter
        return view

    }
    companion object {
        fun newInstance(): HistoryFragment {
            return HistoryFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        historyViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(HistoryViewModel::class.java)
        historyViewModel.historyLiveData.observe(this, Observer { reqList->
            Timber.d(reqList.toString())
            historyList.clear()
            historyList.addAll(ArrayList(reqList))
        })
    }
}
