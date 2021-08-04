package dev.twitter.api

import dev.twitter.model.User
import dev.twitter.service.user.BaseUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@CrossOrigin(origins = ["http://localhost:8081"])
@RestController
@RequestMapping("/api/v1/users")
class UserController @Autowired constructor(private val service: BaseUserService) {

    @GetMapping
    fun users(): List<User> = service.users()

    @GetMapping("/{username}")
    fun findByUsername(@PathVariable("username") username: String): Optional<User> = service.findByUsername(username)

    @PostMapping("/new")
    fun createUser(@RequestBody user: User): User = service.createUser(user)

    @PutMapping("/update")
    fun updateUser(@RequestBody user: User): User = service.createUser(user)

    @DeleteMapping("/{id}")
    fun deleteUserById(@PathVariable("id") id: Long) = service.deleteUserById(id)
}