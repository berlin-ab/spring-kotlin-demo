package demo

import blog.Post
import blog.PostRepository
import org.springframework.stereotype.Component

@Component
class DatabaseInitializer(private val postRepository: PostRepository){
    init {
        postRepository.save(Post(
                title = "Foo",
                body = "Bar"
        ))
    }
}
