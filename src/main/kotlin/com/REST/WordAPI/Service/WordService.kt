package com.REST.WordAPI.Service

import com.REST.WordAPI.Domain.Word
import org.springframework.stereotype.Service

@Service
interface WordService {

    fun findAll(): List<Word?>?

    fun insertWord(word: Word)
}