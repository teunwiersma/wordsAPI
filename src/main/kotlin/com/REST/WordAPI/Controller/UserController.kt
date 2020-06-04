package com.REST.WordAPI.Controller

import com.REST.WordAPI.Model.User
import com.REST.WordAPI.Service.UserService
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource


@RestController
@RequestMapping("/UserAPI")
class UserController {

    @Resource
    var userService: UserService? = null

    @GetMapping(value = ["/users"])
    fun getUsers(): List<User?>? {
        return userService?.findAll();
    }

    @PostMapping(value = ["/createUser"])
    fun createUser(@RequestBody user: User){
        userService?.insertUser(user)
    }
}