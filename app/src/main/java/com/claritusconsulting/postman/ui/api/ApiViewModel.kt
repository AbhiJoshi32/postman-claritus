package com.claritusconsulting.postman.ui.api

import android.app.VoiceInteractor
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.claritusconsulting.postman.data.ApiRequest
import com.claritusconsulting.postman.data.ApiResponse
import com.claritusconsulting.postman.db.RequestDao
import javax.inject.Inject

class ApiViewModel @Inject constructor(requestDao: RequestDao) : ViewModel() {
    val changeLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val responseLiveData: MutableLiveData<ApiResponse> = MutableLiveData()
    val requestId: MutableLiveData<Long> = MutableLiveData()
    val requestLiveData: LiveData<ApiRequest> = Transformations.switchMap(requestId){
        requestDao.findById(it)
    }

    fun setReqId(id: Long) {
        requestId.postValue(id)
    }

    fun getReq(): LiveData<ApiRequest> {
        return requestLiveData
    }
    fun setChange(bool: Boolean) {
        changeLiveData.value = bool
    }

    fun getChange(): LiveData<Boolean> {
        return changeLiveData
    }

    fun getResponse(): LiveData<ApiResponse> {
        return responseLiveData
    }

    fun setResponse(apiResponse: ApiResponse) {
        responseLiveData.postValue(apiResponse)
    }
}