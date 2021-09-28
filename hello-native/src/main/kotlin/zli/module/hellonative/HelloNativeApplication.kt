package zli.module.hellonative

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class HelloNativeApplication

fun main(args: Array<String>) {
    runApplication<HelloNativeApplication>(*args)
}
