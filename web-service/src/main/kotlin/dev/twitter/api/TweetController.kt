package dev.twitter.api

import dev.twitter.model.Tweet
import dev.twitter.service.tweet.BaseTweetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:8081"])
@RestController
@RequestMapping("/api/v1/tweets")
class TweetController @Autowired constructor(private val service: BaseTweetService) {

    @GetMapping("/{username}")
    fun tweets(@PathVariable("username") username: String): List<Tweet> = service.tweets(username)

    @PostMapping("/new")
    fun createTweet(@RequestBody tweet: Tweet): Tweet = service.createTweet(tweet)

    @PutMapping("/update")
    fun updateTweet(@RequestBody tweet: Tweet): Tweet = service.updateTweet(tweet)

    @DeleteMapping("/{id}")
    fun deleteTweetById(@PathVariable("id") id: Long) = service.deleteTweetById(id)
}