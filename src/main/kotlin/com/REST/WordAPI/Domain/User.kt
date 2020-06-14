package com.REST.WordAPI.Domain

class User ( private var name: String, private var highscore: Int){


    fun getUserName(): String? {
        return name
    }

    fun setUserName(name: String){
        this.name = name
    }

    fun getHighscore(): Int? {
        return highscore
    }

    fun setHighscore(highscore: Int){
        this.highscore = highscore
    }
}