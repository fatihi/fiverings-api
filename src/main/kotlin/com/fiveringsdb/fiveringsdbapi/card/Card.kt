package com.fiveringsdb.fiveringsdbapi.card

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
data class Card(
        @Id var id: String,
        var name: String,
        var nameExtra: String?,
        var nameCanonical: String = name.toCanonical(),
        var cost: String?,
        var text: String?,
        var textCanonical: String? = text?.toCanonical(),
        var type: CardType,
        var clan: Clan,
        @ElementCollection var element: MutableList<Element>?,
        @JsonProperty("unicity") var isUnique: Boolean,
        var side: Side,
        @ElementCollection var traits: MutableList<String>,
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
        var roleRestriction: Restriction?,
        var isRestricted: Boolean,
        @ElementCollection @Enumerated(EnumType.STRING) var allowedClans: MutableList<Clan>,
        var isBanned: Boolean)


