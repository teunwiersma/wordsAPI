package com.REST.WordAPI.Controller

import com.REST.WordAPI.Domain.Word
import com.REST.WordAPI.Service.WordService
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource


@RestController
@RequestMapping("/WordAPI")
class WordController {

    @Resource
    var wordService: WordService? = null

    @GetMapping(value = ["/words"])
    fun getWords(): List<Word?>? {
        return wordService?.findAll();

    }

    @PostMapping(value = ["/createWord"])
    fun createEmployee(@RequestBody word: Word) {
        wordService?.insertWord(word)
    }
}