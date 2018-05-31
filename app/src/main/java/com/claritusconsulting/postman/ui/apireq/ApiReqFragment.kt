package com.claritusconsulting.postman.ui.apireq


import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.claritusconsulting.postman.R
import com.claritusconsulting.postman.di.Injectable
import com.claritusconsulting.postman.ui.history.HistoryViewModel
import javax.inject.Inject


class ApiReqFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var apiReqViewModel: ApiReqViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_api_req, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        apiReqViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(ApiReqViewModel::class.java)
    }

}
