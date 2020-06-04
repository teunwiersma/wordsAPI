package com.REST.WordAPI.Controller

import com.REST.WordAPI.Model.User
import com.REST.WordAPI.Model.Word
import com.REST.WordAPI.Service.UserService
import com.REST.WordAPI.Service.WordService
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource


@RestController
@RequestMapping("/WordAPI")
class ApplicationController {

    @Resource
    var wordService: WordService? = null
    var userService: UserService? = null

    @GetMapping(value = ["/words"])
    fun getWords(): List<Word?>? {
        return wordService?.findAll();

    }

    @GetMapping(value = ["/users"])
    fun getUsers(): List<User?>? {
        return userService?.findAll();

    }

    @PostMapping(value = ["/createWord"])
    fun createEmployee(@RequestBody word: Word) {
        wordService?.insertWord(word)
    }

    @PostMapping(value = ["/createUser"])
    fun createUser(@RequestBody user: User){
        userService?.insertUser(user)
    }

}