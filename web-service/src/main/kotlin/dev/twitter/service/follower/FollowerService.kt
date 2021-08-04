package dev.twitter.service.follower

import dev.twitter.repository.FollowerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FollowerService @Autowired constructor(private val repository: FollowerRepository) : BaseFollowerService