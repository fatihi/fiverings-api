package com.fiveringsdb.fiveringsdbapi.ruling

import com.fasterxml.jackson.annotation.*
import com.fiveringsdb.fiveringsdbapi.card.Card
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
data class Ruling(
        @Id
        val id: Int,
        val link: String?,
        val source: String?,
        val text: String,
        @ManyToOne
        @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator::class, property = "id")
        @JsonIdentityReference(alwaysAsId=true)
        @JsonProperty("card_id") val card: Card,
        @JsonIgnore
        val userId: String)
