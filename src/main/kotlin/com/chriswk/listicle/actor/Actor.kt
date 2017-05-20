package com.chriswk.listicle.actor

import com.chriswk.listicle.country.Country
import java.time.Instant
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Actor(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = -1,
        val firstName: String,
        val lastName: String,
        val birthDate: LocalDate,
        @ManyToOne(fetch = FetchType.LAZY) val country: Country,
        val imdbId: String,
        val lastUpdated: Instant,
        val created: Instant
)
