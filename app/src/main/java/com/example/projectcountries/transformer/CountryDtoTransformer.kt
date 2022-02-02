package com.example.projectcountries.transformer

import com.example.projectcountries.dto.CountryDto
import com.example.projectcountries.room.CountryEntity

object CountryDtoTransformer{

    fun CountryDto.convertToEntity(): CountryEntity{
        return CountryEntity(
            this.name,
            this.capital,
            this.population,
            this.latlng,
            this.languages
        )
    }

    fun List<CountryDto>.convertToEntity(): List<CountryEntity>{
        val result = mutableListOf<CountryEntity>()
        for (dto in this){
            result.add(dto.convertToEntity())
        }
        return result
    }


}