package com.fiveringsdb.fiveringsdbapi.cycle

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class CyclesSerializationTest {

    val expected = object {}.javaClass.getResource("/cycle/imperial-cycle.json").readText(Charsets.UTF_8)

    @Autowired
    lateinit var springMvc: MockMvc

    @MockkBean
    lateinit var controllerMock: CyclesController

    @Test
    fun `serializes an array of cycles correctly`() {
        every { controllerMock.getCycles() } returns listOf(TestCycles.ImperialCycle())

        val result = springMvc.perform(MockMvcRequestBuilders.get("/cycles"))
                                .andExpect(status().isOk)
                                .andReturn().response.contentAsString

        assertEquals(result, "[ $expected ]")

        verify { controllerMock.getCycles() }
    }

    @Test
    fun `serializes a single cycle correctly`() {
        every { controllerMock.getCycleById(any()) } returns TestCycles.ImperialCycle()

        val result = springMvc.perform(MockMvcRequestBuilders.get("/cycles/imperial"))
                .andExpect(status().isOk)
                .andReturn().response.contentAsString

        assertEquals(result, expected)

        verify { controllerMock.getCycleById("imperial") }
    }
}
