package com.example.projectcountries.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.projectcountries.dto.CountryDto
import com.example.projectcountries.dto.LanguageV2Dto


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
    val latlng: List<Float>
//
//    @ColumnInfo
//    @TypeConverters(LanguagesV2Converter::class)
//    val languages: List<LanguageV2Dto>
        )

fun CountryDto.convertToEntity(): CountryEntity{
    return CountryEntity(
        this.name,
        this.capital,
        this.population,
        this.latlng
//        this.languages
    )
}

fun List<CountryDto>.convertToEntity(): List<CountryEntity>{
    val result = mutableListOf<CountryEntity>()
    for (dto in this){
        result.add(dto.convertToEntity())
    }
    return result
}