package com.fiveringsdb.fiveringsdbapi.card

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
data class Card(
        @Id var id: String,
        var name: String,
        @JsonProperty("name_extra") var nameExtra: String?,
        @JsonProperty("name_canonical") var nameCanonical: String = name.toCanonical(),
        var cost: String?,
        var text: String?,
        @JsonProperty("text_canonical") var textCanonical: String? = text?.toCanonical(),
        var type: CardType,
        var clan: Clan,
        @ElementCollection(targetClass = Element::class) @Enumerated(EnumType.STRING) var element: List<Element>?,
        @JsonProperty("unicity") var isUnique: Boolean,
        var side: Side,
        @ElementCollection var traits: List<String>,
        var military: String?,
        var political: String?,
        var strength: String?,
        @JsonProperty("military_bonus") var militaryBonus: String?,
        @JsonProperty("political_bonus")var politicalBonus: String?,
        @JsonProperty("strength_bonus")var strengthBonus: String?,
        var glory: String?,
        var honor: Int?,
        var fate: Int?,
        @JsonProperty("influence_pool") var influencePool: Int?,
        @JsonProperty("influence_cost") var influenceCost: Int?,
        @JsonProperty("deck_limit") var deckLimit: Int,
        @JsonProperty("role_restriction") var roleRestriction: Restriction?,
        @JsonProperty("is_restricted") var isRestricted: Boolean,
        @JsonProperty("allowed_clans") @ElementCollection(targetClass = Clan::class) @Enumerated(EnumType.STRING) var allowedClans: List<Clan>,
        @JsonProperty("is_banned") var isBanned: Boolean)


