package com.claritusconsulting.postman.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.claritusconsulting.postman.data.ApiRequest
import com.claritusconsulting.postman.data.ApiResponse

@Dao
interface ResponseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(apiResponse: ApiResponse) : Long

    @Query("SELECT * FROM apiresponse WHERE requestId = :id")
    fun findById(id:String): LiveData<List<ApiResponse>>
}
