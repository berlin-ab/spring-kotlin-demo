package api

import blog.LatestPosts
import blog.LatestPostsObserver
import blog.Post
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.async.DeferredResult

typealias Response = DeferredResult<ResponseEntity<Any>>

@RestController class LatestPostsController(private val latestPosts: LatestPosts) {
    @GetMapping("/latest-posts") fun get() = Response().also {
        latestPosts.fetch(LatestPostsApiObserver(it))
    }
}

class LatestPostsApiObserver(private val result: Response) : LatestPostsObserver {
    override fun latestPostsFound(posts: List<Post>) {
        result.setResult(ResponseEntity.ok(posts))
    }
}
