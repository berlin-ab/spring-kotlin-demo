package blogStorage

import blog.Post
import blog.PostRepository
import org.springframework.stereotype.Component


@Component
class DatabasePostRepository(private val postJpaRepository: PostJpaRepository) : PostRepository {
    override fun save(post: Post) {
        postJpaRepository.save(
                PostEntity(
                        title = post.title,
                        body = post.body
                )
        )
    }

    override fun find(): List<Post> {
        return postJpaRepository.findAll().map {
            Post(
                    title = it.title,
                    body = it.body
            )
        }
    }
}
