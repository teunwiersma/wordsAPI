package com.REST.WordAPI

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HttpRequestUsersTest {

    @LocalServerPort
    private val port = 0

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @Test
    @Throws(Exception::class)
    fun greetingShouldReturnDefaultMessage() {
        Assertions.assertThat(restTemplate!!.getForObject("http://localhost:$port/UserAPI/users", String::class.java)).contains("user")
        Assertions.assertThat(restTemplate!!.getForObject("http://localhost:$port/UserAPI/createUser", String::class.java)).contains("OK")
    }


}