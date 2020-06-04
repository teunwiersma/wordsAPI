package com.REST.WordAPI.Service

import com.REST.WordAPI.Model.User
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun findAll(): List<User?>?

    fun insertUser(user: User)
}