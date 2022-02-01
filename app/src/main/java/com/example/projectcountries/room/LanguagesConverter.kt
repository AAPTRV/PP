package com.example.projectcountries.room

import androidx.room.TypeConverter
import com.example.projectcountries.model.LanguageV2
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LanguagesV2Converter {

    @TypeConverter
    fun fromLanguages(languages: List<LanguageV2>): String{
        val result = Gson()
        return result.toJson(languages)
    }

    @TypeConverter
    fun toLanguages(src: String): List<LanguageV2>{
        val result = Gson()
        val turnsType = object : TypeToken<List<LanguageV2>>() {}.type
        return result.fromJson(src, turnsType)
    }

}