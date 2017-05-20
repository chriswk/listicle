package com.chriswk.listicle.country

import java.time.Instant
import javax.persistence.*

@Entity
data class Country(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = -1,
        @Column(name="iso_3166_alpha2") val iso3166Alpha2: String,
        @Column(name="iso_3166_alpha3") val iso3166Alpha3: String,
        val name: String,
        val lastUpdated: Instant,
        val created: Instant
)

