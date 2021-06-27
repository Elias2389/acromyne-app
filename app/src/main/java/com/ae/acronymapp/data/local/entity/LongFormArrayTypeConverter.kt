package com.ae.acronymapp.data.local.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LongFormArrayTypeConverter {
    val gson = Gson()

    @TypeConverter
    fun stringToLongFormArrayEntity(data: String?): List<LongFormArrayEntity> {
        if (data.isNullOrBlank()) {
            return emptyList()
        }

        val listType = object : TypeToken<List<LongFormArrayEntity>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun longFormArrayEntityToString(list: List<LongFormArrayEntity>): String {
        return gson.toJson(list)
    }
}
