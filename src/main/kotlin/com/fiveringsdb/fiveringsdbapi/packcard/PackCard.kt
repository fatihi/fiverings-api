package com.fiveringsdb.fiveringsdbapi.packcard
import com.fiveringsdb.fiveringsdbapi.card.Card
import com.fiveringsdb.fiveringsdbapi.pack.Pack
import java.io.Serializable
import javax.persistence.*

@Entity
@IdClass(PackCardId::class)
data class PackCard(
        @Id
        @ManyToOne(fetch = FetchType.LAZY, targetEntity = Pack::class)
        @JoinColumn(name="pack_id", referencedColumnName = "id", nullable = false)
        val pack: Pack,
        @Id
        @ManyToOne(fetch = FetchType.LAZY, targetEntity = Card::class)
        @JoinColumn(name="card_id", referencedColumnName = "id", nullable = false)
        val card: Card,
        val quantity: Int,
        val position: String,
        val illustrator: String?,
        val flavor: String?,
        val imageUrl: String?)

data class PackCardId(val card: String, val pack: String) : Serializable
