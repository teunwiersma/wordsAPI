package com.REST.WordAPI.Domain

class User (private var userid: Int, private var username: String, private var password: String, private var highscore: Int){

    fun getId(): Int? {
        return userid
    }

    fun setId(userid: Int){
        this.userid = userid
    }

    fun getUserName(): String? {
        return username
    }

    fun setUserName(username: String){
        this.username = username
    }

    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String){
        this.password = password
    }

    fun getHighscore(): Int? {
        return highscore
    }

    fun setHighscore(highscore: Int){
        this.highscore = highscore
    }
}