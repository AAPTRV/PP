package com.example.projectcountries.model

data class CountryModel (
    val name: String?,
    val capital: String?,
    val population: Int?,
    val latlng: List<Float>?,
    val languages: List<LanguageModel>?
        )