package blogStorage

import blog.PostRepository
import blogStorageContract.PostRepositoryContract
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootApplication
open class TestApplication {}

@SpringBootTest
@RunWith(SpringRunner::class)
class PostRespositoryTest : PostRepositoryContract() {
    @Autowired lateinit var postJpaRepository: PostJpaRepository

    override fun setupRepository(): PostRepository {
        return DatabasePostRepository(postJpaRepository)
    }
}
