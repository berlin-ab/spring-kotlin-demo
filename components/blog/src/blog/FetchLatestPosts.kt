package blog

import javax.inject.Named

interface LatestPostsObserver {
    fun latestPostsFound(posts: List<Post>)
}


@Named
class LatestPosts(private val postRepository: PostRepository) {
    fun fetch(observer: LatestPostsObserver) {
        observer.latestPostsFound(postRepository.find())
    }
}

