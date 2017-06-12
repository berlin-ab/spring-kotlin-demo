package api

import blog.LatestPosts
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

import blog.Post
import org.springframework.web.bind.annotation.RestController

@RestController class LatestPostsController(private val latestPosts: LatestPosts) {

    @GetMapping("/latest-posts")
    fun get() = latestPosts.fetch()

}
