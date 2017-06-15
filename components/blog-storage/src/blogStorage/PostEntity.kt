package blogStorage

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class PostEntity(
        @Id @GeneratedValue val id: Int = -1,
        val title: String = "",
        val body: String = ""
)
