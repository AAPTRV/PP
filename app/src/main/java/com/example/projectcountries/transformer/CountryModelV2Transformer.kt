package com.example.projectcountries.transformer

import com.example.projectcountries.dto.CountryDto
import com.example.projectcountries.dto.LanguageDto
import com.example.projectcountries.model.CountryModel
import com.example.projectcountries.room.CountryEntity
import com.example.projectcountries.transformer.LanguageV2ModelTransformer.convertToDto

object CountryModelV2Transformer {

    fun CountryModel.convertToDto(): CountryDto {
        var name = "No Name"
        var capital = "No capital"
        var population: Int = 0
        val latlng = mutableListOf<Float>()
        val languages = mutableListOf<LanguageDto>()
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
            for (latlngItem in it) {
                latlng.add(latlngItem)
            }
        }
        this.languages?.let {
            languages.addAll(it.convertToDto())
        }
        return CountryDto(
            name,
            capital,
            population,
            latlng,
            languages
        )
    }

    fun List<CountryModel>.convertToDto(): MutableList<CountryDto> {
        val result = mutableListOf<CountryDto>()
        for (model in this) {
            result.add(model.convertToDto())
        }
        return result
    }

    fun CountryModel.convertToEntity(): CountryEntity{
        var name = "No Name"
        var capital = "No capital"
        var population = 0
        val latlng = mutableListOf<Float>()
        val languages = mutableListOf<LanguageDto>()

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
            for (latlngItem in it) {
                latlng.add(latlngItem)
            }
        }
        this.languages?.let {
            languages.addAll(it.convertToDto())
        }
        return CountryEntity(
            name,
            capital,
            population,
            latlng,
            languages
        )
    }

    fun List<CountryModel>.convertToEntity(): List<CountryEntity>{
        val result = mutableListOf<CountryEntity>()
        for (model in this){
            result.add(model.convertToEntity())
        }
        return result
    }

}