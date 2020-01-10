package com.fiveringsdb.fiveringsdbapi.card

import com.fiveringsdb.fiveringsdbapi.packcard.TestPackCards

object TestCards {
  fun WayOfThePhoenix(): Card = Card(id = "way-of-the-phoenix", name = "Way of the Phoenix", type = CardType.Event,
        clan = Clan.Phoenix, isUnique = false, side = Side.Conflict, traits = mutableListOf("philosophy"),
        deckLimit = 3, isRestricted = false, allowedClans = mutableListOf(Clan.Phoenix), isBanned = false,
        nameExtra = null, cost = "0", text = "<b>Action:</b> Choose a ring and an opponent - that " +
        "player cannot declare conflicts of that ring's element this phase. (Max 1 per phase.)",
        element = null, fate = null, glory = null, honor = null, influenceCost = null, influencePool = null,
        military = null, militaryBonus = null, political = null, politicalBonus = null, roleRestriction = null,
        strength = null, strengthBonus = null
  )

  fun AdmitDefeat(): Card = Card(id = "admit-defeat", name = "Admit Defeat", type = CardType.Event,
          clan = Clan.Crane, isUnique = false, side = Side.Conflict, traits = mutableListOf(),
          deckLimit = 3, isRestricted = false, allowedClans = mutableListOf(), isBanned = false,
          nameExtra = null, cost = "1", text = "<b>Action:</b> Choose a character that is defending alone – bow that character.",
          element = null, fate = null, glory = null, honor = null, influenceCost = 2, influencePool = null,
          military = null, militaryBonus = null, political = null, politicalBonus = null, roleRestriction = null,
          strength = null, strengthBonus = null
  )
}
