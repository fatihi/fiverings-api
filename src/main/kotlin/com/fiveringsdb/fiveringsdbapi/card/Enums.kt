package com.fiveringsdb.fiveringsdbapi.card

import com.fasterxml.jackson.annotation.JsonValue

fun allClans(): List<Clan> = listOf(Clan.Crab, Clan.Crane, Clan.Dragon, Clan.Lion, Clan.Scorpion, Clan.Phoenix, Clan.Unicorn)
fun allElements(): List<Element> = listOf(Element.Air, Element.Earth, Element.Fire, Element.Void, Element.Water)

enum class Restriction {
    Seeker,
    Keeper,
    Air,
    Earth,
    Fire,
    Void,
    Water;

    @JsonValue
    fun forJackson(): String {
        return name.toLowerCase()
    }
}

enum class Side {
    Conflict,
    Dynasty,
    Role,
    Province,
    Treaty;

    @JsonValue
    fun forJackson(): String {
        return name.toLowerCase()
    }
}

enum class Element {
    Air,
    Earth,
    Fire,
    Void,
    Water;

    @JsonValue
    fun forJackson(): String {
        return name.toLowerCase()
    }
}

enum class Clan {
    Crab,
    Crane,
    Dragon,
    Lion,
    Scorpion,
    Phoenix,
    Unicorn,
    Neutral;

    @JsonValue
    fun forJackson(): String {
        return name.toLowerCase()
    }

}

enum class CardType {
    Event,
    Character,
    Stronghold,
    Attachment,
    Role,
    Province,
    Treaty,
    Holding;

    @JsonValue
    fun forJackson(): String {
        return name.toLowerCase()
    }
}
