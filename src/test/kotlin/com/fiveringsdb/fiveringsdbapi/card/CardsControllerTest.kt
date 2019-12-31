package com.fiveringsdb.fiveringsdbapi.card

import com.fiveringsdb.fiveringsdbapi.ruling.RulingsController
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertFailsWith

class CardsControllerTest {

    var repoMock: CardsRepository = mockk()
    var rulingsControllerMock: RulingsController = mockk()
    private val wayOfThePhoenix = "way-of-the-phoenix"

    @Test
    fun `getCards calls the repository`() {
        every { repoMock.findAll() } returns listOf()
        val cardsController = CardsController(repoMock, rulingsControllerMock)

        cardsController.getCards()

        verify { repoMock.findAll() }
    }

    @Test
    fun `getCardById calls the repository`() {
        every { repoMock.findById(wayOfThePhoenix) } returns Optional.of(TestCards.WayOfThePhoenix())
        val cardsController = CardsController(repoMock, rulingsControllerMock)

        val card = cardsController.getCardById(wayOfThePhoenix)

        assertEquals(card.id, wayOfThePhoenix)
        verify { repoMock.findById(wayOfThePhoenix) }
    }

    @Test
    fun `getCardById throws a NoSuchElementException when there is no card for the id`() {
        every { repoMock.findById(any()) } returns Optional.empty()
        val cardsController = CardsController(repoMock, rulingsControllerMock)

        val exception = assertFailsWith<NoSuchElementException> { cardsController.getCardById(wayOfThePhoenix) }
        assertTrue(exception.message == "Could not find a card with id $wayOfThePhoenix")
        verify { repoMock.findById(wayOfThePhoenix) }
    }

    @Test
    fun `getRulingsForCard calls the ruling controller`() {
        val card = TestCards.WayOfThePhoenix()
        every { repoMock.findById(wayOfThePhoenix) } returns Optional.of(card)
        every { rulingsControllerMock.getRulingsForCard(any()) } returns listOf()
        val cardsController = CardsController(repoMock, rulingsControllerMock)

        cardsController.getRulingsForCard(wayOfThePhoenix)

        verify { repoMock.findById(wayOfThePhoenix) }
        verify { rulingsControllerMock.getRulingsForCard(card)}
    }

    @Test
    fun `getRulingsForCard throws a NoSuchElementException when there is no card for the id`() {
        every { repoMock.findById(any()) } returns Optional.empty()
        val cardsController = CardsController(repoMock, rulingsControllerMock)

        val exception = assertFailsWith<NoSuchElementException> { cardsController.getRulingsForCard(wayOfThePhoenix) }
        assertTrue(exception.message == "Could not find a card with id $wayOfThePhoenix")
        verify { repoMock.findById(wayOfThePhoenix) }
    }
}