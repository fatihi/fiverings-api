package com.fiveringsdb.fiveringsdbapi.label

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/labels")
class LabelsController(private val labelsRepository: LabelsRepository) {

    @GetMapping
    fun getLabels(): List<Label> {
        labelsRepository.findAll()
        return listOf(TestLabels.Air(), TestLabels.Philosophy(), TestLabels.Technique())
    }
}