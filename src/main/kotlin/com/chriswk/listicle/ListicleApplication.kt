package com.chriswk.listicle

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.*
import javax.annotation.PostConstruct

@SpringBootApplication
open class ListicleApplication

fun main(args: Array<String>) {
    TimeZone.setDefault( TimeZone.getTimeZone( "UTC" ) );
    SpringApplication.run(ListicleApplication::class.java, *args)
}