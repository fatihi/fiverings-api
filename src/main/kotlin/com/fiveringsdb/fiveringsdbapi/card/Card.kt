package com.fiveringsdb.fiveringsdbapi.card

import javax.persistence.*

@Entity
class Card(
        @Id var id: String,
        var name: String,
        var nameExtra: String?,
        var nameCanonical: String = name.toCanonical(),
        var cost: String?,
        var text: String?,
        var textCanonical: String? = text?.toCanonical(),
        var type: CardType,
        var clan: Clan,
        @ElementCollection(targetClass = Element::class) @Enumerated(EnumType.STRING) var element: List<Element>?,
        var isUnique: Boolean,
        var side: Side,
        @ElementCollection var traits: List<String>,
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
        @ElementCollection(targetClass = Clan::class) @Enumerated(EnumType.STRING) var allowedClans: List<Clan>,
        var isBanned: Boolean)


