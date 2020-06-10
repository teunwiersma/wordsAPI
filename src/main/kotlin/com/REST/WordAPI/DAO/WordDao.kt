package com.REST.WordAPI.DAO

import com.REST.WordAPI.Domain.Word

interface WordDao {
    fun findAll(): List<Word?>?
    fun insertWord(word: Word)
}