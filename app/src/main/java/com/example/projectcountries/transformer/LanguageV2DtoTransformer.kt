package com.example.projectcountries.transformer

import com.example.projectcountries.dto.LanguageDto

object LanguageV2DtoTransformer {

    fun List<LanguageDto>.convertToString(): String {
        if(this.isEmpty()){
            return "No languages available"
        }
        var result = ""
        for (language in this) {
            result += language.name
            result += " "
        }
        return result
    }

}