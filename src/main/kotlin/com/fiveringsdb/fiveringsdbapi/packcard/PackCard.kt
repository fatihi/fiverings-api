package com.fiveringsdb.fiveringsdbapi.packcard
import java.io.Serializable
import javax.persistence.*

@Entity
@IdClass(PackCardId::class)
data class PackCard(
        @Id
        val packId: String,
        @Id
        val cardId: String,
        val quantity: Int,
        val position: String,
        val illustrator: String?,
        val flavor: String?,
        val imageUrl: String?)

class PackCardId(val cardId: String, val packId: String) : Serializable
