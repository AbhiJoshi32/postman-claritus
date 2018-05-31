package com.claritusconsulting.postman.ui.history

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.claritusconsulting.postman.data.Request
import com.claritusconsulting.postman.repo.RequestRepo
import javax.inject.Inject

class HistoryViewModel @Inject constructor(requestRepo: RequestRepo) : ViewModel() {
    val historyLiveData: LiveData<List<Request>> = requestRepo.loadRequests();
}