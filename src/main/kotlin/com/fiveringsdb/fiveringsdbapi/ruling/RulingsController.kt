package com.fiveringsdb.fiveringsdbapi.ruling

import com.fiveringsdb.fiveringsdbapi.card.Card
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rulings")
class RulingsController(private val rulingsRepository: RulingsRepository) {
    @GetMapping
    fun getRulings(): List<Ruling> {
        rulingsRepository.findAll()
        return listOf(TestRulings.WayOfThePhoenixRuling(), TestRulings.AdmitDefeatRuling())
    }

    @GetMapping("/{id}")
    fun getRulingById(@PathVariable("id") id: Int) : Ruling {
        return rulingsRepository.findById(id)
                .orElseThrow { NoSuchElementException("Could not find a ruling with id $id") }

    }

    fun getRulingsForCard(card: Card): List<Ruling> {
        return getRulings().filter { it.card == card }
    }
}

