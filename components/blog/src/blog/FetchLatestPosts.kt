package blog

import javax.inject.Named

interface LatestPostsObserver {
    fun latestPostsFound(posts: List<Post>)
}

interface LatestPosts {
    fun fetch(observer: LatestPostsObserver)
}

@Named
class StandardLatestPosts(private val postRepository: PostRepository) : LatestPosts {
    override fun fetch(observer: LatestPostsObserver) {
        observer.latestPostsFound(postRepository.find())
    }
}

