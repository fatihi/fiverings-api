package com.fiveringsdb.fiveringsdbapi.ruling

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
class RulingSerializationTest {

    @Autowired
    lateinit var springMvc: MockMvc

    @MockkBean
    lateinit var controllerMock: RulingsController

    private val expectedJson =
            object {}.javaClass.getResource("/ruling/way-of-the-phoenix-ruling.json").readText(Charsets.UTF_8)

    @Test
    fun `serializes an array of rulings correctly`() {
        every { controllerMock.getRulings() } returns listOf(TestRulings.WayOfThePhoenixRuling(), TestRulings.WayOfThePhoenixRuling())

        val result = springMvc.perform(MockMvcRequestBuilders.get("/rulings"))
                                .andExpect(status().isOk)
                                .andReturn().response.contentAsString

        assertEquals(result, "[ $expectedJson, $expectedJson ]")

        verify { controllerMock.getRulings() }
    }

    @Test
    fun `serializes a single ruling correctly`() {
        every { controllerMock.getRulingById(any()) } returns TestRulings.WayOfThePhoenixRuling()

        val result = springMvc.perform(MockMvcRequestBuilders.get("/rulings/127"))
                .andExpect(status().isOk)
                .andReturn().response.contentAsString

        assertEquals(result, expectedJson)

        verify { controllerMock.getRulingById(127) }
    }
}
