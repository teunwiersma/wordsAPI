package com.REST.WordAPI.Domain

class Word (private var word: String){


    fun setWord(word: String) {
        this.word = word
    }

    fun getWord(): String? {
        return word
    }

}