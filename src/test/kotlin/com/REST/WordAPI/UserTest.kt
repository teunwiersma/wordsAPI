package com.REST.WordAPI

import com.REST.WordAPI.Domain.User
import com.REST.WordAPI.Domain.Word
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class UserTest {

    private val u: User = User( "henk",  0);
    private val getUserName = u.getUserName();
    private val getHighscore = u.getHighscore();

    private var check: Boolean = false


    @Test
    fun contextLoads() {
        Assertions.assertThat(getUserName).isEqualTo("henk")
        Assertions.assertThat(getHighscore).isEqualTo(0)

        u.setHighscore(20)
        u.setUserName("peter")
        if(u.getHighscore() == 20 &&  u.getUserName() == "peter"){
            check = true
        }
        Assertions.assertThat(check).isTrue()
    }

}