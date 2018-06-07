package com.claritusconsulting.postman.ui.history

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.claritusconsulting.postman.data.ApiRequest
import com.claritusconsulting.postman.repo.RequestRepo
import javax.inject.Inject

class HistoryViewModel @Inject constructor(val requestRepo: RequestRepo) : ViewModel() {
    val historyLiveData: MutableLiveData<List<ApiRequest>> = MutableLiveData()
    fun getHistory(): LiveData<List<ApiRequest>> {
        return requestRepo.loadRequests()
    }
}