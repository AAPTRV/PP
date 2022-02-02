package com.example.projectcountries.dto

data class CountryDto (
    val name: String,
    val capital: String,
    val population: Int,
    val latlng: List<Float>,
    val languages: List<LanguageDto>
        )




