package blog

interface Post {
        val title: String
        val body: String

}

data class PostModel(
        override val title: String = "",
        override val body: String = ""
) : Post
