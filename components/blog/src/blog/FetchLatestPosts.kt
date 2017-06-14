package blog

import javax.inject.Named

@Named
class LatestPosts {
    fun fetch() : List<Post> {
        return listOf(
                Post(
                        title = "Kotlin",
                        body = "Some post"
                ),
                Post(
                        title = "Other kotlin",
                        body = "Some other post"
                )
        )
    }
}

