package com.fiveringsdb.fiveringsdbapi.pack

import com.fiveringsdb.fiveringsdbapi.cycle.TestCycles
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertFailsWith

class PacksControllerTest {

    var repoMock: PacksRepository = mockk()
    private val id = "core"

    @Test
    fun `getPacks calls the repository`() {
        every { repoMock.findAll() } returns listOf()
        val packsController = PacksController(repoMock)

        packsController.getPacks()

        verify { repoMock.findAll() }
    }

    @Test
    fun `getPackById calls the repository`() {
        every { repoMock.findById(id) } returns Optional.of(TestPacks.Core())
        val packsController = PacksController(repoMock)

        val pack = packsController.getPackById(id)

        assertEquals(pack.id, id)
        assertEquals(pack.cycle, TestCycles.Core())
        verify { repoMock.findById(id) }
    }

    @Test
    fun `getRulingById throws a NoSuchElementException when there is no ruling for the id`() {
        every { repoMock.findById(id) } returns Optional.empty()
        val packsController = PacksController(repoMock)

        val exception = assertFailsWith<NoSuchElementException> { packsController.getPackById(id) }
        assertTrue(exception.message == "Could not find a pack with id $id")
        verify { repoMock.findById(id) }
    }
}