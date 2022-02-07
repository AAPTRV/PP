package com.example.projectcountries.transformer

import com.example.projectcountries.dto.LanguageDto
import com.example.projectcountries.model.LanguageModel

object LanguageV2ModelTransformer {

        fun LanguageModel.convertToDto(): LanguageDto {
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
            return LanguageDto(iso639_1, iso639_2, name, nativeName)
        }

        fun List<LanguageModel>.convertToDto(): MutableList<LanguageDto>{
            val result = mutableListOf<LanguageDto>()
            for(language in this){
                result.add(language.convertToDto())
            }
            return result
        }

}