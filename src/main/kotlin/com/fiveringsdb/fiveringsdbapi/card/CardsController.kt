package com.fiveringsdb.fiveringsdbapi.card

import com.fiveringsdb.fiveringsdbapi.ruling.Ruling
import com.fiveringsdb.fiveringsdbapi.ruling.RulingsController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cards")
class CardsController(private val cardsRepository: CardsRepository,
                      private val rulingsController: RulingsController) {
    @GetMapping
    fun getCards(): List<Card> {
        cardsRepository.findAll()
        return listOf(TestCards.WayOfThePhoenix(), TestCards.AdmitDefeat())
    }

    @GetMapping("/{id}")
    fun getCardById(@PathVariable("id") id: String): Card {
        return cardsRepository.findById(id)
               .orElseThrow { NoSuchElementException("Could not find a card with id $id") }

    }

    @GetMapping("/{id}/rulings")
    fun getRulingsForCard(@PathVariable("id") id: String): List<Ruling> {
        return rulingsController.getRulingsForCard(getCardById(id))

    }
}

