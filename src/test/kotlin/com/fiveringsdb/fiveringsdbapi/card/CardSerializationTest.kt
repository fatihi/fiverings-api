package com.fiveringsdb.fiveringsdbapi.card

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class CardSerializationTest {

    @Autowired
    lateinit var springMvc: MockMvc

    @MockkBean
    lateinit var controllerMock: CardsController

    @Test
    fun `serializes an array of cards correctly`() {
        every { controllerMock.getCards() } returns listOf(TestCards.WayOfThePhoenix())

        val result = springMvc.perform(MockMvcRequestBuilders.get("/cards"))
                                .andExpect(status().isOk)
                                .andReturn().response.contentAsString

        val expected = object {}.javaClass.getResource("/card/way-of-the-phoenix.json").readText(Charsets.UTF_8)
        assertEquals(result, "[ $expected ]")

        verify { controllerMock.getCards() }
    }

    @Test
    fun `serializes a single card correctly`() {
        every { controllerMock.getCardById(any()) } returns TestCards.WayOfThePhoenix()

        val result = springMvc.perform(MockMvcRequestBuilders.get("/cards/way-of-the-phoenix"))
                .andExpect(status().isOk)
                .andReturn().response.contentAsString

        val expected = object {}.javaClass.getResource("/card/way-of-the-phoenix.json").readText(Charsets.UTF_8)
        assertEquals(result, expected)

        verify { controllerMock.getCardById("way-of-the-phoenix") }
    }
}
