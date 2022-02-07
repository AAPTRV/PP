package com.example.projectcountries.transformer

import com.example.projectcountries.dto.CountryDto
import com.example.projectcountries.room.CountryEntity

object CountryEntityTransformer {

    fun CountryEntity.convertToDto(): CountryDto{
        return CountryDto(
            this.name,
            this.capital,
            this.population,
            this.latlng,
            this.languages,
            this.flag
        )
    }

    fun List<CountryEntity>.convertToDto(): MutableList<CountryDto>{
        val result = mutableListOf<CountryDto>()
        for(entity in this){
            result.add(entity.convertToDto())
        }
        return result
    }

}