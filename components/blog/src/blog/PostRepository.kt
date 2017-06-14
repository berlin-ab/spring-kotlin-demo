package blog

interface PostRepository {
    fun save(post: Post)
    fun find(): List<Post>
}
