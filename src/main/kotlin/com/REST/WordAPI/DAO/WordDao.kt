package com.REST.WordAPI.DAO

import com.REST.WordAPI.Model.Word

interface WordDao {
    fun findAll(): List<Word?>?
    fun insertWord(w: Word?)
}