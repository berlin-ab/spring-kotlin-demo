package demo

import blog.Post
import blog.PostModel
import blog.PostRepository
import org.springframework.stereotype.Component

@Component
class DatabaseInitializer(private val postRepository: PostRepository){
    init {
        postRepository.save(PostModel(
                title = "Foo",
                body = "Bar"
        ))
    }
}
