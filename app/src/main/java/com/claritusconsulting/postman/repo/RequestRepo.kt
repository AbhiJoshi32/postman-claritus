package com.claritusconsulting.postman.repo

import android.arch.lifecycle.LiveData
import com.claritusconsulting.postman.AppExecutors
import com.claritusconsulting.postman.data.Request
import com.claritusconsulting.postman.db.RequestDao
import javax.inject.Inject
import javax.inject.Singleton



@Singleton
class RequestRepo @Inject constructor(
        private val appExecutors: AppExecutors,
        private val reqDao: RequestDao
) {
    fun loadRequests(): LiveData<List<Request>> {
        return reqDao.findAll();
    }
    fun insertRequest(request: Request) {
        appExecutors.diskIO().execute {
            reqDao.insert(request)
        }
    }
}