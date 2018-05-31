package com.claritusconsulting.postman.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.claritusconsulting.postman.db.PostmanTypeConverters

import com.google.gson.annotations.SerializedName

@Entity
@TypeConverters(PostmanTypeConverters::class)
data class  Request(
        @PrimaryKey(autoGenerate = true)
        var requestId: Int?,
        var url: String?,
        var method: String?,
        var header: List<Header>?
){
    constructor():this(null,"","", emptyList<Header>())
}