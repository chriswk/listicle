package com.chriswk.listicle.country

import org.springframework.data.repository.CrudRepository

interface CountryRepository : CrudRepository<Country, Long> {
    fun findByIso3166Alpha2(alpha2Code: String): Country
    fun findByIso3166Alpha3(alpha3Code: String): Country
}

