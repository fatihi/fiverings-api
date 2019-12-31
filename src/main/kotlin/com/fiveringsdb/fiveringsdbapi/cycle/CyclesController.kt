package com.fiveringsdb.fiveringsdbapi.cycle

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cycles")
class CyclesController(private val cyclesRepository: CyclesRepository) {

    @GetMapping
    fun getCycles(): List<Cycle> {
        cyclesRepository.findAll()
        return listOf(TestCycles.ClanPacksCycle(), TestCycles.ImperialCycle())
    }

    @GetMapping("/{id}")
    fun getCycleById(@PathVariable("id") id: String): Cycle {
        return cyclesRepository.findById(id)
               .orElseThrow { NoSuchElementException("Could not find a cycle with id $id") }

    }
}

