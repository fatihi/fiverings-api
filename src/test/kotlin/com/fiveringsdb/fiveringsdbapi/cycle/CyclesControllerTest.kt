package com.fiveringsdb.fiveringsdbapi.cycle

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertFailsWith

class CyclesControllerTest {

    var repoMock: CyclesRepository = mockk()
    private val imperial = "imperial"

    @Test
    fun `getCycles calls the repository`() {
        every { repoMock.findAll() } returns listOf()
        val cyclesController = CyclesController(repoMock)

        cyclesController.getCycles()

        verify { repoMock.findAll() }
    }

    @Test
    fun `getCycleById calls the repository`() {
        every { repoMock.findById(imperial) } returns Optional.of(TestCycles.ImperialCycle())
        val cyclesController = CyclesController(repoMock)

        val cycle = cyclesController.getCycleById(imperial)

        assertEquals(cycle.id, imperial)
        verify { repoMock.findById(imperial) }
    }

    @Test
    fun `getCycleById throws a NoSuchElementException when there is no cycle for the id`() {
        every { repoMock.findById(imperial) } returns Optional.empty()
        val cyclesController = CyclesController(repoMock)

        val exception = assertFailsWith<NoSuchElementException> { cyclesController.getCycleById(imperial) }
        assertTrue(exception.message == "Could not find a cycle with id $imperial")
        verify { repoMock.findById(imperial) }
    }
}