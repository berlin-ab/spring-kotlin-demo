package interesting

import junit.framework.Assert.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

data class Author(
        val name: String
)

data class BlogPost(
        val name: String,
        val body: String,
        val author: Author
)

class TestFactory {
    fun createBlogPost(
            name: String = "Kotlin is great",
            body: String = "It allows for default parameters",
            author: Author = createAuthor()
    ): BlogPost {
        return BlogPost(
                name = name,
                body = body,
                author = author
        )
    }

    fun createAuthor(name: String = "Adam Berlin"): Author {
        return Author(
                name = name
        )
    }
}

@RunWith(JUnitPlatform::class)
class NamedParametersSpec : Spek({
    it("allows for making useful objects such as a test factory") {
        val actual = TestFactory().createBlogPost()

        assertEquals(actual, BlogPost(
                name = "Kotlin is great",
                body = "It allows for default parameters",
                author = Author(name = "Adam Berlin")
        ))
    }

    it("allows to override parts of the object to be built") {
        val actual = TestFactory().createBlogPost(
                name = "Even better"
        )

        assertEquals(actual, BlogPost(
                name = "Even better",
                body = "It allows for default parameters",
                author = Author(name = "Adam Berlin")
        ))
    }
})