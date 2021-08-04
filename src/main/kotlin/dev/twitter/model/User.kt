package dev.twitter.model

import com.fasterxml.jackson.annotation.JsonIgnore
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
    @JsonIgnore
    val password: String,
    var username: String,
    @OneToMany(mappedBy = "follower")
    val followers: MutableList<Follower> = mutableListOf(),
) : Serializable
