package api

import blog.Post
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders


class LatestPostsControllerTest {
    val latestPosts = LatestPostsStub()
    val latestPostsController = LatestPostsController(
            latestPosts = latestPosts
    )
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
