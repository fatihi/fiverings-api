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
        var pack: Pack,
        @Id
        @ManyToOne(fetch = FetchType.LAZY, targetEntity = Card::class)
        @JoinColumn(name="card_id", referencedColumnName = "id", nullable = false)
        var card: Card,
        var quantity: Int,
        var position: String,
        var illustrator: String?,
        var flavor: String?,
        var imageUrl: String?)

data class PackCardId(val card: String, val pack: String) : Serializable
