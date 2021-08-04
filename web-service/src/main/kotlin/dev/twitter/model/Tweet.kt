package dev.twitter.model

import java.io.Serializable
import java.sql.Timestamp
import javax.persistence.*

/**
 * [Tweet] entity
 */
@Entity
data class Tweet(
    @Id
    @GeneratedValue
    val tweetId: Long,
    var tweetMessage: String,
    val createdAt: Timestamp,
    @ManyToOne
    val user: User,
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "comment_tweet_id_tweet_id")
    val comments: MutableList<Comment> = mutableListOf(),
    var updatedAt: Timestamp? = null,
) : Serializable
