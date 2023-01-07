package me.toelke.pwgen;

import java.lang.StringBuilder
import java.security.SecureRandom
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
class PasswordService {
    fun generatePassword(
        length: Int,
        characters: String = DefaultCharacters
    ): String {
        val random = SecureRandom()
        val builder = StringBuilder()

        for(i in 0 until length) {
            random.nextInt(characters.length).let {
                builder.append(characters[it])
            }
        }

        return builder.toString()
    }

    companion object {
        const val DefaultCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    }
}
