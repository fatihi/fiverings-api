package com.fiveringsdb.fiveringsdbapi.card

import com.fasterxml.jackson.annotation.JsonValue



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
