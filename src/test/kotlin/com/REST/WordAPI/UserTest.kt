package com.REST.WordAPI

import com.REST.WordAPI.Domain.User
import com.REST.WordAPI.Domain.Word
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class UserTest {

    private val u: User = User(1, "henk", "henkie", 0);
    private val getUserName = u.getUserName();
    private val getPassword = u.getPassword();
    private val getHighscore = u.getHighscore();
    private val getId = u.getId();

    private var check: Boolean = false


    @Test
    fun contextLoads() {
        Assertions.assertThat(getUserName).isEqualTo("henk")
        Assertions.assertThat(getPassword).isEqualTo("henkie")
        Assertions.assertThat(getHighscore).isEqualTo(0)
        Assertions.assertThat(getId).isEqualTo(1)

        u.setHighscore(20)
        u.setId(2)
        u.setPassword("sjaak")
        u.setUserName("peter")
        if(u.getHighscore() == 20 &&  u.getId() == 2 && u.getPassword() == "sjaak" && u.getUserName() == "peter"){
            check = true
        }
        Assertions.assertThat(check).isTrue()
    }

}