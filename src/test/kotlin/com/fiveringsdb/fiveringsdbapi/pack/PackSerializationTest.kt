package com.fiveringsdb.fiveringsdbapi.pack

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
class PackSerializationTest {

    @Autowired
    lateinit var springMvc: MockMvc

    @MockkBean
    lateinit var controllerMock: PacksController

    private val expectedJson =
            object {}.javaClass.getResource("/pack/core.json").readText(Charsets.UTF_8)

    @Test
    fun `serializes an array of packs correctly`() {
        every { controllerMock.getPacks() } returns listOf(TestPacks.Core(), TestPacks.Core())

        val result = springMvc.perform(MockMvcRequestBuilders.get("/packs"))
                                .andExpect(status().isOk)
                                .andReturn().response.contentAsString

        assertEquals(result, "[ $expectedJson, $expectedJson ]")

        verify { controllerMock.getPacks() }
    }

    @Test
    fun `serializes a single ruling correctly`() {
        every { controllerMock.getPackById(any()) } returns TestPacks.Core()

        val result = springMvc.perform(MockMvcRequestBuilders.get("/packs/core"))
                .andExpect(status().isOk)
                .andReturn().response.contentAsString

        assertEquals(result, expectedJson)

        verify { controllerMock.getPackById("core") }
    }
}
