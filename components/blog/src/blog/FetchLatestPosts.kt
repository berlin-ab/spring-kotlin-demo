package blog

data class Post(
        val title: String,
        val body: String
)

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

