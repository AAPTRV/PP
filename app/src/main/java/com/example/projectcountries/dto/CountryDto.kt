package com.example.projectcountries.dto

import com.example.projectcountries.model.CountryModelV2

data class CountryDto (
    val name: String,
    val capital: String,
    val population: Int,
    val latlng: List<Float>,
    val languages: List<LanguageV2Dto>
        )

fun CountryModelV2.convertToDto(): CountryDto{
    var name = "No Name"
    var capital = "No capital"
    var population: Int = 0
    val latlng = mutableListOf<Float>()
    val languages = mutableListOf<LanguageV2Dto>()
    this.name?.let {
        name = it
    }
    this.capital?.let {
        capital = it
    }
    this.population?.let {
        population = it
    }
    this.latlng?.let {
        for (latlngItem in it){
            latlng.add(latlngItem)
        }
    }
    this.languages?.let{
        languages.addAll(it.convertToDto())
    }
    return CountryDto(name,capital, population, latlng, languages)
}

fun List<CountryModelV2>.convertToDto(): List<CountryDto>{
    val result = mutableListOf<CountryDto>()
    for (model in this){
        result.add(model.convertToDto())
    }
    return result
}