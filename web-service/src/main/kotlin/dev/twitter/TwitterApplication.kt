package dev.twitter

import dev.twitter.model.User
import dev.twitter.service.user.BaseUserService
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.exchange
import java.util.stream.Collectors


@SpringBootApplication
class TwitterApplication {

    @Suppress("UNCHECKED_CAST")
    @Bean
    fun run(userService: BaseUserService): ApplicationRunner = ApplicationRunner {
        /**
         * get random users
         */
        if (System.currentTimeMillis() <= 1628045240492) {
            val url = "https://randomuser.me/api/?page=3&results=5"
            val headers = HttpHeaders()
            headers.accept = listOf(MediaType.APPLICATION_JSON)
            val entity = HttpEntity<Map<String, Any>>(headers)
            val body = RestTemplate().exchange<Map<String, Any>>(url, HttpMethod.GET, entity).body
            val results = body?.get("results") as ArrayList<Map<String, Any>>
            val usersToSave = results.stream()
                .map { person ->
                    User(
                        id = 0,
                        firstName = (person["name"] as Map<String, Any>)["first"].toString(),
                        lastName = (person["name"] as Map<String, Any>)["last"].toString(),
                        username = (person["login"] as Map<String, Any>)["username"].toString(),
                        email = person["email"].toString(),
                        password = (person["login"] as Map<String, Any>)["password"].toString(),
                        avatar = (person["picture"] as Map<String, Any>)["large"].toString(),
                    )
                }
                .collect(Collectors.toList())

            /**
             * save users to database
             */
            usersToSave.forEach { userService.createUser(it) }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<TwitterApplication>(*args)
}
