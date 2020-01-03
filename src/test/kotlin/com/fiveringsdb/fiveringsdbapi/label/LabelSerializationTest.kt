package com.fiveringsdb.fiveringsdbapi.label

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
class LabelSerializationTest {

    @Autowired
    lateinit var springMvc: MockMvc

    @MockkBean
    lateinit var controllerMock: LabelsController

    private val expectedJson =
            object {}.javaClass.getResource("/label/philosophy.json").readText(Charsets.UTF_8)

    @Test
    fun `serializes an array of labels correctly`() {
        every { controllerMock.getLabels() } returns listOf(TestLabels.Philosophy(), TestLabels.Philosophy())

        val result = springMvc.perform(MockMvcRequestBuilders.get("/labels"))
                                .andExpect(status().isOk)
                                .andReturn().response.contentAsString

        assertEquals(result, "[ $expectedJson, $expectedJson ]")

        verify { controllerMock.getLabels() }
    }
}
