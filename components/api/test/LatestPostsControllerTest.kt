package api

import blog.LatestPosts
import blog.LatestPostsObserver
import blog.Post
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class LatestPostsControllerTest {
    val latestPosts = LatestPostsStub()
    val latestPostsController = LatestPostsController(latestPosts = latestPosts)
    val client = MockMvcBuilders.standaloneSetup(latestPostsController).build()

    @Before
    fun setUp() {
        latestPosts.stub(
                listOf(
                        Post(
                                title = "foo",
                                body = "bar"
                        )
                )
        )
    }

    @Test
    fun itReturnsPosts() {
        val request = client.performAsync(get("/latest-posts"))

        assertThat(request.response.contentAsString).isEqualToIgnoringWhitespace("""
            [{"title":"foo","body":"bar"}]
        """)
    }
}

fun MockMvc.performAsync(request: MockHttpServletRequestBuilder): MvcResult {
    return perform(
            asyncDispatch(perform(request).andReturn())
    ).andReturn()
}

class LatestPostsStub : LatestPosts {
    private var stubbedPosts: List<Post> = emptyList()

    override fun fetch(observer: LatestPostsObserver) {
        observer.latestPostsFound(stubbedPosts)
    }

    fun stub(posts: List<Post>) {
        stubbedPosts = posts
    }
}

