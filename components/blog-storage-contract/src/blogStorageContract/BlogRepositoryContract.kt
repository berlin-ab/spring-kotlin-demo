package blogStorageContract

import blog.Post
import blog.PostModel
import blog.PostRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

abstract class PostRepositoryContract {

    lateinit var repository: PostRepository
    abstract fun setupRepository(): PostRepository

    @Before
    fun setup() {
        repository = setupRepository();
    }

    @Test
    fun itStoresBlogs() {
        repository.save(PostModel(title = "Foo", body = "Bar"))
        val posts = repository.find()

        assertThat(posts).isEqualTo(listOf(PostModel(title = "Foo", body = "Bar")))
    }

}


