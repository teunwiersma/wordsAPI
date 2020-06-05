package com.REST.WordAPI.Controller

import com.REST.WordAPI.Model.User
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

    @GetMapping("/login/{username}/{password}")
    @ResponseStatus(HttpStatus.OK)
    fun login(@PathVariable("username") username: String,
              @PathVariable("password") password: String):MutableList<User>?{
        return userService?.login(username, password)
    }

    @PostMapping("/createUser")
    fun createUser(@RequestBody user: User){
        userService?.insertUser(user)
    }


}