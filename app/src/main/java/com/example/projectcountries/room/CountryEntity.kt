package com.example.projectcountries.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.projectcountries.dto.LanguageDto
import com.example.projectcountries.room.converters.LanguagesV2Converter
import com.example.projectcountries.room.converters.LatLngConverter


@Entity(tableName = "countries_data_base_table_info")
class CountryEntity (
    @PrimaryKey
    @ColumnInfo
    val name: String,

    @ColumnInfo
    val capital: String,

    @ColumnInfo
    val population: Int,

    @ColumnInfo(name = "latlng")
    @TypeConverters(LatLngConverter::class)
    val latlng: List<Float>,

    @ColumnInfo (name = "languages")
    @TypeConverters(LanguagesV2Converter::class)
    val languages: List<LanguageDto>
        )



