package dev.twitter.model

import java.io.Serializable
import javax.persistence.*

/**
 * [Follower] entity
 */
@Entity
data class Follower constructor(
    @Id
    @GeneratedValue
    val id: Long,
    @ManyToOne
    @JoinColumn(name = "follower")
    val follower: User,
    @ManyToOne
    @JoinColumn(name = "followee")
    val followee: User,
) : Serializable
