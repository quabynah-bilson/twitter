package dev.twitter.service.tweet

import dev.twitter.model.Tweet

interface BaseTweetService {
    fun tweets(username: String): List<Tweet>

    fun createTweet(tweet: Tweet): Tweet

    fun updateTweet(tweet: Tweet) : Tweet

    fun deleteTweetById(id: Long)
}