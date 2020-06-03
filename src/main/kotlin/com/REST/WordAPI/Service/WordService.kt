package com.REST.WordAPI.Service

import com.REST.WordAPI.Model.Word

interface WordService {
    fun findAll(): List<Word?>?

    fun insertWord(emp: Word?)
}