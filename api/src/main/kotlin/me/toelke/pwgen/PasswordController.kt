package me.toelke.pwgen

import org.jboss.resteasy.reactive.RestQuery
import javax.ws.rs.DefaultValue
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/password")
class PasswordController(
    private val service: PasswordService
) {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    fun generate(
        @DefaultValue("32" ) @RestQuery length: Int = 32,
        @DefaultValue("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789") @RestQuery characters: String
    ): PasswordResponse {
        return PasswordResponse(service.generatePassword(length, characters))
    }

    data class PasswordResponse(val password: String)
}