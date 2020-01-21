package com.fiveringsdb.fiveringsdbapi.card

import com.fasterxml.jackson.annotation.JsonProperty
import com.fiveringsdb.fiveringsdbapi.packcard.PackCard
import javax.persistence.*

@Entity
data class Card(
        @Id
        var id: String,
        var name: String,
        var nameExtra: String?,
        @Transient
        var nameCanonical: String = name.toCanonical(),
        var cost: String?,
        @Column( length = 10000 )
        var text: String?,
        @Transient
        var textCanonical: String? = text?.toCanonical(),
        @Enumerated(EnumType.STRING)
        var type: CardType,
        @Enumerated(EnumType.STRING)
        var clan: Clan,
        @ElementCollection
        var element: MutableList<Element>?,
        @JsonProperty("unicity")
        var isUnique: Boolean,
        @Enumerated(EnumType.STRING)
        var side: Side,
        @ElementCollection
        var traits: MutableList<String>,
        var military: String?,
        var political: String?,
        var strength: String?,
        var militaryBonus: String?,
        var politicalBonus: String?,
        var strengthBonus: String?,
        var glory: String?,
        var honor: Int?,
        var fate: Int?,
        var influencePool: Int?,
        var influenceCost: Int?,
        var deckLimit: Int,
        @Enumerated(EnumType.STRING)
        var roleRestriction: Restriction?,
        var isRestricted: Boolean,
        @ElementCollection
        @Enumerated(EnumType.STRING)
        var allowedClans: MutableList<Clan>,
        var isBanned: Boolean,
        @OneToMany(mappedBy = "card",
                cascade = [CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE],
                targetEntity = PackCard::class,
                orphanRemoval = true,
                fetch = FetchType.EAGER)
        var packCards: MutableList<PackCard> = mutableListOf()
)
