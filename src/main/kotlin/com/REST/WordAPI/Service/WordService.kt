package com.REST.WordAPI.Service

import com.REST.WordAPI.Model.Word
import org.springframework.stereotype.Service

@Service
interface WordService {

    fun findAll(): List<Word?>?

    fun insertWord(emp: Word?)
}