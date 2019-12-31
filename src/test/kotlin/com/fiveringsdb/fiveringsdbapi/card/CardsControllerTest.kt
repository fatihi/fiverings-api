package com.fiveringsdb.fiveringsdbapi.card

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*
import kotlin.NoSuchElementException
import kotlin.test.assertFailsWith

internal class CardsControllerTest {

    var repoMock: CardsRepository = mockk()
    private val wayOfThePhoenix = "way-of-the-phoenix"

    @Test
    fun `getCards calls the repository`() {
        every { repoMock.findAll() } returns listOf()
        val cardsController = CardsController(repoMock)

        cardsController.getCards()

        verify { repoMock.findAll() }
    }

    @Test
    fun `getCardById calls the repository`() {
        every { repoMock.findById(wayOfThePhoenix) } returns Optional.of(TestCards.WayOfThePhoenix())
        val cardsController = CardsController(repoMock)

        val card = cardsController.getCardById(wayOfThePhoenix)

        assertEquals(card.id, wayOfThePhoenix)
        verify { repoMock.findById(wayOfThePhoenix) }
    }

    @Test
    fun `getCardById throws a NoSuchElementException when there is no card for the id`() {
        every { repoMock.findById(any()) } returns Optional.empty()
        val cardsController = CardsController(repoMock)

        val exception = assertFailsWith<NoSuchElementException> { cardsController.getCardById(wayOfThePhoenix) }
        assertTrue(exception.message == "Could not find a card with id $wayOfThePhoenix")
        verify { repoMock.findById(wayOfThePhoenix) }
    }
}