package com.REST.WordAPI.Controller

import com.REST.WordAPI.Domain.User
import com.REST.WordAPI.Service.UserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource


@RestController
@RequestMapping("/UserAPI")
class UserController {

    @Resource
    var userService: UserService? = null

    @GetMapping("/users")
    fun getUsers(): List<User?>? {
        return userService?.findAll();
    }

    @PostMapping("/createUser")
    fun createUser(@RequestBody user: User): HttpStatus {
        userService?.insertUser(user)
        return HttpStatus.OK
    }


}