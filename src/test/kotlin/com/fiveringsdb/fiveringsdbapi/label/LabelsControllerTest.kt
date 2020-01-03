package com.fiveringsdb.fiveringsdbapi.label

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class LabelsControllerTest {

    var repoMock: LabelsRepository = mockk()
    private val id = "core"

    @Test
    fun `getPacks calls the repository`() {
        every { repoMock.findAll() } returns listOf()
        val labelsController = LabelsController(repoMock)

        labelsController.getLabels()

        verify { repoMock.findAll() }
    }
}