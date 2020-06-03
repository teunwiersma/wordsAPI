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

    var word = Word(1,"oeps")

    @GetMapping(value = ["/words"])
    fun getWords(): Word? {
        var words = wordService?.findAll()
        if(words == null){
            return word
        }
        return word;

    }

    @PostMapping(value = ["/createWord"])
    fun createEmployee(@RequestBody w: Word?) {
        wordService?.insertWord(w)
    }
}