package com.REST.WordAPI.DAO

import com.REST.WordAPI.Domain.User

interface UserDao {
    fun findAll(): List<User?>?
    fun insertUser(user: User)
    fun login(username:String, password:String): MutableList<User>?
}