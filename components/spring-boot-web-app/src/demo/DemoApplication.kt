package demo

import api.ApiApp
import blog.LatestPosts
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication(
        scanBasePackageClasses = arrayOf(
                DemoApplication::class,
                ApiApp::class
        )
)
class DemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
}

