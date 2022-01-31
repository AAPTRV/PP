package com.example.projectcountries.dto

import com.example.projectcountries.model.LanguageV2

data class LanguageV2Dto (
    val iso639_1: String,
    val iso639_2: String,
    val name: String,
    val nativeName: String
)

fun LanguageV2.convertToDto(): LanguageV2Dto{
    var iso639_1: String = "No iso 639_1"
    var iso639_2: String = "No iso 639_2"
    var name: String = "No name"
    var nativeName: String = "No native name"
    this.iso639_1?.let {
        iso639_1 = it
    }
    this.iso639_2?.let {
        iso639_2 = it
    }
    this.name?.let {
        name = it
    }
    this.nativeName?.let {
        nativeName = it
    }
    return LanguageV2Dto(iso639_1, iso639_2, name, nativeName)
}

fun List<LanguageV2>.convertToDto(): List<LanguageV2Dto>{
    val result = mutableListOf<LanguageV2Dto>()
    for(language in this){
        result.add(language.convertToDto())
    }
    return result
}

fun List<LanguageV2Dto>.convertToString(): String{
    var result = ""
    for(language in this){
        result += language.name
        result += " "
    }
    return result.trim()
}
