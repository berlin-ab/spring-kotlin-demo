package blogStorage

import blog.Post
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class PostEntity(
        @Id @GeneratedValue val id: Int,
        override val title: String,
        override val body: String
) : Post
