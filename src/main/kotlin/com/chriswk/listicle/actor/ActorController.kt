package com.chriswk.listicle.actor

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController(value = "/actor")
class ActorController(val repository: ActorRepository) {

    @GetMapping("/actor")
    fun findAll() = repository.findAll()

    @GetMapping("/actor/imdb/{id}")
    fun findByImdbId(@PathVariable("id") id: String) = repository.findByImdbId(id)

}

