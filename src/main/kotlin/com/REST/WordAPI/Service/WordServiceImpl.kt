package com.REST.WordAPI.Service

import com.REST.WordAPI.DAO.WordDao
import com.REST.WordAPI.Model.Word
import org.springframework.stereotype.Component
import javax.annotation.Resource

@Component
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