package demo

import api.ApiApp
import blog.BlogApp
import blogStorage.BlogStorageApp
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication(
        scanBasePackageClasses = arrayOf(
                DemoApplication::class,
                ApiApp::class,
                BlogApp::class,
                BlogStorageApp::class
        )
)
class DemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
}
