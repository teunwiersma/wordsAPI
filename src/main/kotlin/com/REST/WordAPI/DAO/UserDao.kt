package com.REST.WordAPI.DAO

import com.REST.WordAPI.Model.User

interface UserDao {
    fun findAll(): List<User?>?
    fun insertUser(user: User)
}