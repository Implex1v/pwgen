package me.toelke.pwgen;

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Tag
import java.lang.StringBuilder
import java.security.SecureRandom
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
class PasswordService(
    private val meterRegistry: MeterRegistry
) {
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

        meterRegistry.counter("password_generated", listOf(Tag.of("length", length.toString())))
        return builder.toString()
    }

    companion object {
        const val DefaultCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
    }
}
