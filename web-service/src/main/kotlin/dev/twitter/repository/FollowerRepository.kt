package dev.twitter.repository

import dev.twitter.model.Follower
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FollowerRepository : JpaRepository<Follower, Long>