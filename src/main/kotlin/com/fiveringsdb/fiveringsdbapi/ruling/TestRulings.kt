package com.fiveringsdb.fiveringsdbapi.ruling

import com.fiveringsdb.fiveringsdbapi.card.Card
import com.fiveringsdb.fiveringsdbapi.card.TestCards

object TestRulings {
    fun WayOfThePhoenixRuling(): Ruling = Ruling(id = 127,
            link = "http://www.cardgamedb.com/forums/index.php?/topic/37118-rings-with-multiple-elements/",
            source = "Developer Ruling",
            text = "If you choose a ring that gained other elements during a conflict (e.g. via [Seeker of Knowledge](seeker-of-knowledge), " +
                    "[Isawa Kaede](isawa-kaede)), the effect will prevent your opponent from initiating conflicts with any of those elements " +
                    "until the end of the phase.",
            card = TestCards.WayOfThePhoenix(),
            userId = "avasadasdasd")

    fun AdmitDefeatRuling(): Ruling = Ruling(id = 4,
            link = "https://fiveringsdb.com/rules/reference#participating-and-cannot-participate",
            source = "RGG \\\"Participating and Cannot Participate\\\"",
            text = "If a participating character is bowed, it is still considered participating.",
            card = TestCards.AdmitDefeat(),
            userId = "avasadasdasd")
}