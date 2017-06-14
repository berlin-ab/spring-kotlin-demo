package blog

import javax.inject.Named

@Named
class LatestPosts(private val postRepository: PostRepository) {
    fun fetch() : List<Post> {
        return postRepository.find()
    }
}

