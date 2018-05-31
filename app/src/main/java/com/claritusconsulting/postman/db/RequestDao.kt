package com.claritusconsulting.postman.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.claritusconsulting.postman.data.Request

@Dao
interface RequestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(request: Request)

    @Query("SELECT * FROM request")
    fun findAll(): LiveData<List<Request>>
}
