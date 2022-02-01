package com.example.projectcountries.model

data class CountryModelV2 (
    val name: String?,
    val capital: String?,
    val population: Int?,
    val latlng: List<Float>?,
    val languages: List<LanguageV2>?
        )
