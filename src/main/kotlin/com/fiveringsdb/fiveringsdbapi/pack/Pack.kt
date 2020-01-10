package com.fiveringsdb.fiveringsdbapi.pack
import com.fasterxml.jackson.annotation.*
import com.fiveringsdb.fiveringsdbapi.card.Card
import com.fiveringsdb.fiveringsdbapi.cycle.Cycle
import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Pack(
        @Id
        val id: String,
        val name: String,
        val position: Int,
        val size: Int,
        val releasedAt: LocalDate?,
        @ManyToOne
        @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
        @JsonIdentityReference(alwaysAsId=true)
        @JsonProperty("cycle_id")
        val cycle: Cycle)
