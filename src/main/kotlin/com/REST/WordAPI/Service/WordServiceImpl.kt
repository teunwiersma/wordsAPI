package com.REST.WordAPI.Service

import com.REST.WordAPI.DAO.WordDao
import com.REST.WordAPI.Model.Word
import javax.annotation.Resource

class WordServiceImpl : WordService {

    @Resource
    var wordDao: WordDao? = null

    override fun findAll(): List<Word?>? {
        return wordDao?.findAll()
    }

    override fun insertWord(emp: Word?) {
        wordDao?.insertWord(emp)
    }
}