package com.example.projectcountries.dto

import com.example.projectcountries.model.CountryModelV2

data class CountryDto (
    val name: String
        )

fun List<CountryModelV2>.convertToDto(): List<CountryDto>{
    val result = mutableListOf<CountryDto>()
    for(country in this){
        country.name?.let {
            result.add(CountryDto(it))
        }
    }
    return result
}