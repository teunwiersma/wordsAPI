package com.REST.WordAPI.Model

class Word (private var id: Int, private var word: String){


    fun getId(): Int? {
        return id
    }

    fun setId(id: Int){
        this.id = id
    }

    fun setWord(word: String) {
        this.word = word
    }

    fun getWord(): String? {
        return word
    }

}