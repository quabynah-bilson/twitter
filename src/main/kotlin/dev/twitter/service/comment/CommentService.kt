package dev.twitter.service.comment

import dev.twitter.repository.CommentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CommentService @Autowired constructor(private val repository: CommentRepository) : BaseCommentService {
}