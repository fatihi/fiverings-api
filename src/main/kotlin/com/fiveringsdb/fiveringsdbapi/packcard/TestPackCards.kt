package com.fiveringsdb.fiveringsdbapi.packcard

import com.fiveringsdb.fiveringsdbapi.card.TestCards
import com.fiveringsdb.fiveringsdbapi.cycle.TestCycles
import com.fiveringsdb.fiveringsdbapi.pack.TestPacks
import java.time.LocalDate

object TestPackCards {
    fun AdmitDefeatInCore(): PackCard = PackCard(card = TestCards.AdmitDefeat(),
            pack = TestPacks.Core(),
            position = "147",
            flavor = "It is not only a question of defeating one's opponents, but defeating them in such a manner that they know they have been beaten.",
            imageUrl = "http://lcg-cdn.fantasyflightgames.com/l5r/L5C01_147.jpg",
            illustrator = "David Horne",
            quantity = 3)

    fun WayOfThePhoenixInCore(): PackCard = PackCard(card = TestCards.WayOfThePhoenix(),
            pack = TestPacks.Core(),
            position = "176",
            flavor = "Master the elements and be reborn.",
            imageUrl = "http://lcg-cdn.fantasyflightgames.com/l5r/L5C01_176.jpg",
            illustrator = "Scott Wade",
            quantity = 3)

}