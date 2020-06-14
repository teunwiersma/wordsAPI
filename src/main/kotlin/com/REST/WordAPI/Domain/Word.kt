package com.REST.WordAPI.Domain

import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize
class Word constructor(private var word: String){

    fun Word(){

    }
    fun getWord(): String? {
        return word
    }


    fun setWord(word: String) {
        this.word = word
    }

}