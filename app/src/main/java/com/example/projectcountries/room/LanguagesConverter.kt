package com.example.projectcountries.room

import androidx.room.TypeConverter
import com.example.projectcountries.dto.LanguageV2Dto
import com.example.projectcountries.model.LanguageV2
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LanguagesV2Converter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromLanguages(languages: List<LanguageV2Dto>): String {
            val result = Gson()
            return result.toJson(languages)
        }

        @TypeConverter
        @JvmStatic
        fun toLanguages(src: String): List<LanguageV2Dto> {
            val result = Gson()
            val turnsType = object : TypeToken<List<LanguageV2>>() {}.type
            return result.fromJson(src, turnsType)

        }
    }
}