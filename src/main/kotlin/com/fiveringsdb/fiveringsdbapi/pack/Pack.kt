package com.fiveringsdb.fiveringsdbapi.pack
import com.fasterxml.jackson.annotation.*
import com.fiveringsdb.fiveringsdbapi.card.Card
import com.fiveringsdb.fiveringsdbapi.cycle.Cycle
import com.fiveringsdb.fiveringsdbapi.packcard.PackCard
import java.time.LocalDate
import java.util.*
import javax.persistence.*

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
        val cycle: Cycle,
        @OneToMany(mappedBy = "pack",
                cascade = [CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE],
                targetEntity = PackCard::class,
                orphanRemoval = true,
                fetch = FetchType.EAGER)
        val packCards: MutableList<PackCard> = mutableListOf()
)
