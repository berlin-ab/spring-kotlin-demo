package blogStorage

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

interface BlogStorageApp


@EnableJpaRepositories
@EntityScan
@Configuration
open class BlogStorageConfig