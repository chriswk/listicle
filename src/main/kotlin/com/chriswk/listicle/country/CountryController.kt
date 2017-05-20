package com.chriswk.listicle.country

import org.apache.log4j.LogManager
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController(value = "/country")
class CountryController(val repository: CountryRepository) {
    val logger: Logger = LoggerFactory.getLogger("CountryController")
    @GetMapping("/country")
    fun findAll() = repository.findAll()

    @GetMapping("/country/alpha2/{code}")
    fun findByCode(@PathVariable("code") code: String) = repository.findByIso3166Alpha2(code.toUpperCase())

    @GetMapping("/country/alpha3/{code}")
    fun findBy3LetterCode(@PathVariable("code") code: String) = repository.findByIso3166Alpha3(code.toUpperCase())

}