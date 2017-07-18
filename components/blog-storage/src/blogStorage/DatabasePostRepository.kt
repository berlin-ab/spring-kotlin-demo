package blogStorage

import blog.Post
import blog.PostModel
import blog.PostRepository
import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component


@Component
class DatabasePostRepository(private val postJpaRepository: PostJpaRepository) : PostRepository {
    val mapper = ObjectMapper()

    init {
        mapper.configure(FAIL_ON_UNKNOWN_PROPERTIES, false)
    }

    override fun save(post: Post) {
        postJpaRepository.save(
                mapper.convertValue(post, PostEntity::class.java)
        )
    }

    override fun find(): List<Post> {
        return postJpaRepository.findAll().map {
            mapper.convertValue(it, PostModel::class.java)
        }
    }
}
