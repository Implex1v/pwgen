package me.toelke.pwgen

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@QuarkusTest
class PasswordControllerTest {
    @Test
    fun shouldGeneratePassword() {
        val response =  given().post("/password")
        Assertions.assertEquals(response.statusCode, 200)
        val password = response.jsonPath().get<String>("password")

        Assertions.assertEquals(32, password.length)
        password.forEach { Assertions.assertTrue(PasswordService.DefaultCharacters.contains(it)) }
    }

    @Test
    fun shouldUseCustomPasswordLength() {
        val response =  given().post("/password?length=5")
        Assertions.assertEquals(response.statusCode, 200)
        val password = response.jsonPath().get<String>("password")

        Assertions.assertEquals(5, password.length)
        password.forEach { Assertions.assertTrue(PasswordService.DefaultCharacters.contains(it)) }
    }

    @Test
    fun shouldUseCustomCharacters() {
        val response =  given().post("/password?length=5&characters=abcd")
        Assertions.assertEquals(response.statusCode, 200)
        val password = response.jsonPath().get<String>("password")

        Assertions.assertEquals(5, password.length)
        password.forEach { Assertions.assertTrue("abcd".contains(it)) }
    }
}