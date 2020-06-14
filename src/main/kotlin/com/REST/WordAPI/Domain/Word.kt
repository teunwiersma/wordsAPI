package com.REST.WordAPI.Domain

class Word constructor(private var word: String){

    fun Word() {}

    fun setWord(word: String) {
        this.word = word
    }

    fun getWord(): String? {
        return word
    }

}