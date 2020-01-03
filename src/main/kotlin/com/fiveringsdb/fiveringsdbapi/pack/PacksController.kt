package com.fiveringsdb.fiveringsdbapi.pack

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/packs")
class PacksController(private val packsRepository: PacksRepository) {
    @GetMapping
    fun getPacks(): List<Pack> {
        packsRepository.findAll()
        return listOf(TestPacks.Core(), TestPacks.SeekersOfWisdom())
    }

    @GetMapping("/{id}")
    fun getPackById(@PathVariable("id") id: String) : Pack {
        return packsRepository.findById(id)
                .orElseThrow { NoSuchElementException("Could not find a pack with id $id") }

    }
}

