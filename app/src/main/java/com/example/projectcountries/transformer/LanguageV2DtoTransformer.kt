package com.example.projectcountries.transformer

import com.example.projectcountries.dto.LanguageDto

object LanguageV2DtoTransformer {

    fun List<LanguageDto>.convertToString(): String {

        var result = ""

        when (this.size) {
            0 -> result = "No languages available."
            1 -> result = "${this[0].name}."
            else -> {
                this.forEachIndexed { index, language ->
                    result += if (index == this.size - 1) {
                        "${language.name}."
                    } else {
                        "${language.name}, "
                    }
                }
            }
        }
        return result
    }
}