package dev.twitter.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import javax.persistence.*

/**
 * [User] entity
 */
@Entity
@Table(name = "users")
data class User constructor(
    @Id
    @GeneratedValue
    val id: Long,
    val email: String,
    @Column(nullable = false, updatable = true)
    val password: String,
    @Column(unique = true, updatable = false)
    val username: String,
    @Column(name = "first_name")
    @JsonProperty("first_name")
    var firstName: String,
    @Column(name = "last_name")
    @JsonProperty("last_name")
    var lastName: String,
    var avatar: String? = null,
    @OneToMany(mappedBy = "follower")
    val followers: MutableList<Follower> = mutableListOf(),
) : Serializable
