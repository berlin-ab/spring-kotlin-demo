package demo

import api.ApiApp
import blog.BlogApp
import blogStorage.BlogStorageApp
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(
        scanBasePackageClasses = arrayOf(
                DemoApplication::class,
                ApiApp::class,
                BlogApp::class,
                BlogStorageApp::class
        )
)
@EnableJpaRepositories(
        basePackageClasses = arrayOf(BlogStorageApp::class)
)
@EntityScan(
        basePackageClasses = arrayOf(BlogStorageApp::class)
)
class DemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
}
