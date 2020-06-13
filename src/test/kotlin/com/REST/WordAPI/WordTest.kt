package com.REST.WordAPI

import com.REST.WordAPI.Controller.WordController
import com.REST.WordAPI.Domain.Word
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class WordTest {

    private val w: Word = Word("appel");
    private val getWord: String? = w.getWord();
    private var check: Boolean = false


    @Test
    fun contextLoads() {
        Assertions.assertThat(getWord).isEqualTo("appel")
        w.setWord("aardbij")
        if(w.getWord() === "aardbij"){
            check = true
        }
        Assertions.assertThat(check).isTrue()
    }

}
