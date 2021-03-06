package dev.twitter.api

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:8081"])
@RestController
@RequestMapping("/api/v1/followers")
class FollowerController {

}