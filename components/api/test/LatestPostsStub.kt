package api

import blog.LatestPosts
import blog.LatestPostsObserver
import blog.Post

class LatestPostsStub : LatestPosts {
    private var stubbedPosts: List<Post> = emptyList()

    override fun fetch(observer: LatestPostsObserver) {
        observer.latestPostsFound(stubbedPosts)
    }

    fun stub(posts: List<Post>) {
        stubbedPosts = posts
    }
}

