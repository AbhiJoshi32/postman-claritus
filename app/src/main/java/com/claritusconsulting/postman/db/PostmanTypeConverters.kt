package com.claritusconsulting.postman.db

import android.arch.persistence.room.TypeConverter
import com.claritusconsulting.postman.data.Header
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson
import java.util.*
import kotlin.collections.ArrayList


object PostmanTypeConverters {

    private val gson = Gson()
    @TypeConverter
    @JvmStatic
    fun stringToSomeObjectList(data: String?): List<Header> {
        if (data == "null") {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<ArrayList<Header>>() {}.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    @JvmStatic
    fun someObjectListToString(someObjects: List<Header>): String {
        return gson.toJson(someObjects)
    }
}