package com.fiveringsdb.fiveringsdbapi.ruling

import com.fiveringsdb.fiveringsdbapi.card.TestCards
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*
import kotlin.NoSuchElementException
import kotlin.test.assertFailsWith

internal class RulingsControllerTest {

    var repoMock: RulingsRepository = mockk()
    private val id = 127

    @Test
    fun `getRulings calls the repository`() {
        every { repoMock.findAll() } returns listOf()
        val rulingsController = RulingsController(repoMock)

        rulingsController.getRulings()

        verify { repoMock.findAll() }
    }

    @Test
    fun `getRulingById calls the repository`() {
        every { repoMock.findById(id) } returns Optional.of(TestRulings.WayOfThePhoenixRuling())
        val rulingsController = RulingsController(repoMock)

        val ruling = rulingsController.getRulingById(id)

        assertEquals(ruling.id, id)
        assertEquals(ruling.card, TestCards.WayOfThePhoenix())
        verify { repoMock.findById(id) }
    }

    @Test
    fun `getRulingById throws a NoSuchElementException when there is no ruling for the id`() {
        every { repoMock.findById(any()) } returns Optional.empty()
        val rulingsController = RulingsController(repoMock)

        val exception = assertFailsWith<NoSuchElementException> { rulingsController.getRulingById(id) }
        assertTrue(exception.message == "Could not find a ruling with id $id")
        verify { repoMock.findById(id) }
    }

    @Test
    fun `getRulingsForCard filters the rulings by card`() {
        every { repoMock.findAll() } returns listOf(TestRulings.AdmitDefeatRuling(), TestRulings.WayOfThePhoenixRuling())
        val rulingsController = RulingsController(repoMock)

        val rulingsForWayOfThePhoenix = rulingsController.getRulingsForCard(TestCards.WayOfThePhoenix())

        assertEquals(rulingsForWayOfThePhoenix.size, 1)
        verify {repoMock.findAll() }
    }
}