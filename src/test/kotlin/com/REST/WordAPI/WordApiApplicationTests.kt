package com.REST.WordAPI

import com.REST.WordAPI.Controller.UserController
import com.REST.WordAPI.Controller.WordController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class WordApiApplicationTests {

	@Autowired
	private val c: WordController? = null

	@Autowired
	private val uc: UserController? = null

	@Test
	fun contextLoads() {
		assertThat(c).isNotNull();
		assertThat(uc).isNotNull();
	}

}
