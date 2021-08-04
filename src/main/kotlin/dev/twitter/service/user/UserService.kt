package dev.twitter.service.user

import dev.twitter.model.User
import dev.twitter.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService @Autowired constructor(private val repository: UserRepository) : BaseUserService {

    override fun users(): List<User> = repository.findAll()

    override fun findByUsername(username: String): Optional<User> = repository.findByUsername(username)

    override fun createUser(user: User): User = repository.saveAndFlush(user)

    override fun deleteUserById(id: Long) = repository.deleteById(id)
}