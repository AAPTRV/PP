package com.example.projectcountries.room.converters

import androidx.room.TypeConverter
import com.example.projectcountries.dto.LanguageDto
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LanguagesV2Converter {

    companion object {

        @TypeConverter
        @JvmStatic
        fun fromLanguages(languages: List<LanguageDto>): String {
            val result = Gson()
            return result.toJson(languages)
        }

        @TypeConverter
        @JvmStatic
        fun toLanguages(src: String): List<LanguageDto> {
            val result = Gson()
            val turnsType = object : TypeToken<List<LanguageDto>>() {}.type
            return result.fromJson(src, turnsType)

        }
    }
}