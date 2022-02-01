package com.example.projectcountries.room

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LatLngConverter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromLatlng(latlng: List<Float>?): String? {
            val result = Gson()
            return result.toJson(latlng)
        }

        @TypeConverter
        @JvmStatic
        fun toLatlng(src: String): List<Float> {
            val result = Gson()
            val turnsType = object : TypeToken<List<Float>>() {}.type
            return result.fromJson(src, turnsType)

        }
    }
}

