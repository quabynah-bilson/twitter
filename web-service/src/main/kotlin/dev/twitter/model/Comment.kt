package dev.twitter.model

import java.io.Serializable
import java.sql.Timestamp
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

/**
 * [Comment] entity
 */
@Entity
data class Comment(
    @Id
    @GeneratedValue
    val commentId: Long,
    var commentText: String,
    @ManyToOne
    val commentUserId: User,
    @ManyToOne
    val commentTweetId: Tweet,
    val createdAt: Timestamp,
    var updatedAt: Timestamp? = null,
) : Serializable
