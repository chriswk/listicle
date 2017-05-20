package com.chriswk.listicle.actor

import org.springframework.data.repository.CrudRepository

interface ActorRepository : CrudRepository<Actor, Long> {
    fun findByLastName(name: String): Actor
    fun findByImdbId(id: String): Actor
}

