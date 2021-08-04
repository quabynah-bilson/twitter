package dev.twitter.service.user

import dev.twitter.model.User
import java.util.*

interface BaseUserService {
    fun users(): List<User>

    fun findByUsername(username: String): Optional<User>

    fun createUser(user: User): User

    fun deleteUserById(id: Long)
}