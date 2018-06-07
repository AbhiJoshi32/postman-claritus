package com.claritusconsulting.postman.ui.apireq

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.claritusconsulting.postman.data.ApiRequest
import com.claritusconsulting.postman.repo.RequestRepo
import javax.inject.Inject

class ApiReqViewModel @Inject constructor(requestRepo: RequestRepo) : ViewModel() {

}