package com.fiveringsdb.fiveringsdbapi.card

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cards")
class CardsController(private val cardsRepository: CardsRepository) {
    @GetMapping
    fun getCards(): List<Card> =
        listOf(Card(id = "way-of-the-phoenix",
                name = "Way of the Phoenix",
                type = CardType.Event,
                clan = Clan.Phoenix,
                isUnique = false,
                side = Side.Conflict,
                traits = listOf(),
                deckLimit = 3,
                isRestricted = false,
                allowedClans = listOf(Clan.Phoenix),
                isBanned = false,
                nameExtra = null,
                cost = "0",
                text = "AWESOMEEEE",
                element = null,
                fate = null,
                glory = null,
                honor = null,
                influenceCost = null,
                influencePool = null,
                military = null,
                militaryBonus = null,
                political = null,
                politicalBonus = null,
                roleRestriction = null,
                strength = null,
                strengthBonus = null))
        //cardsRepository.findAll()

}

