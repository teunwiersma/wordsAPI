package com.REST.WordAPI

import com.REST.WordAPI.Domain.Word
import com.REST.WordAPI.Service.WordService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import javax.annotation.Resource

class InsertWordTest {

    @Resource
    var wordService: WordService? = null


    @Test
    fun contextLoads() {
        Assertions.assertThat((wordService?.insertWord((Word("testen")))))
        Assertions.assertThat((wordService?.findAll()))
    }
}