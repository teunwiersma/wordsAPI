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

    @GetMapping("/words")
    fun getWords(): List<Word?>? {
        return wordService?.findAll();
    }

    @PostMapping("/insertWord")
    fun insertWord(@RequestParam  w: String) {
        var word: Word = Word(w)
        wordService?.insertWord(word)
    }
}