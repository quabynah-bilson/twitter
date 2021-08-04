package dev.twitter.service.tweet

import dev.twitter.model.Tweet
import dev.twitter.repository.TweetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TweetService @Autowired constructor(private val repository: TweetRepository) : BaseTweetService {

    override fun tweets(username: String): List<Tweet> =
        repository.findAll()
            .stream()
            .filter { it.user.username == username }
            .collect(Collectors.toList())

    override fun createTweet(tweet: Tweet): Tweet = repository.saveAndFlush(tweet)

    override fun updateTweet(tweet: Tweet): Tweet = repository.save(tweet)

    override fun deleteTweetById(id: Long) = repository.deleteById(id)
}