package com.REST.WordAPI.Service

import com.REST.WordAPI.DAO.UserDao
import com.REST.WordAPI.Domain.User
import org.springframework.stereotype.Component
import javax.annotation.Resource

@Component
class UserServiceImpl : UserService{

    @Resource
    var userDao: UserDao? = null

    override fun findAll(): List<User?>? {
        return userDao?.findAll()
    }

    override fun insertUser(user: User) {
        userDao?.insertUser(user)
    }
}