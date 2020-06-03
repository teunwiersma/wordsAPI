package com.REST.WordAPI.Controller

import com.REST.WordAPI.Model.Word
import com.REST.WordAPI.Service.WordService
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource


@RestController
@RequestMapping("/WordAPI")
class ApplicationController {

    @Resource
    var wordService: WordService? = null


    @GetMapping(value = ["/words"])
    fun getWords(): List<Word?>? {
        var words = wordService?.findAll()
        return words;

    }

    @PostMapping(value = ["/createWord"])
    fun createEmployee(@RequestBody w: Word) {
        wordService?.insertWord(w)
    }
}