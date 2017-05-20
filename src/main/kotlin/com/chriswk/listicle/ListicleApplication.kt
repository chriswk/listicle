package com.chriswk.listicle

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ListicleApplication

fun main(args: Array<String>) {
    SpringApplication.run(ListicleApplication::class.java, *args)
}
