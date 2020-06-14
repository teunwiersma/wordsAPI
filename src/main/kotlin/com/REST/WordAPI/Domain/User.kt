package com.REST.WordAPI.Domain

class User ( private var username: String, private var highscore: Int){


    fun getUserName(): String? {
        return username
    }

    fun setUserName(username: String){
        this.username = username
    }

    fun getHighscore(): Int? {
        return highscore
    }

    fun setHighscore(highscore: Int){
        this.highscore = highscore
    }
}