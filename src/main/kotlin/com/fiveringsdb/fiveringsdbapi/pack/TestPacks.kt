package com.fiveringsdb.fiveringsdbapi.pack

import com.fiveringsdb.fiveringsdbapi.cycle.TestCycles
import java.time.LocalDate

object TestPacks {
    fun SeekersOfWisdom(): Pack = Pack(id = "seekers-of-wisdom",
            name = "Seekers of Wisdom",
            position = 7,
            releasedAt = LocalDate.parse("2019-12-06"),
            size = 28,
            cycle = TestCycles.ClanPacksCycle(),
            ffgId = "L5C25")

    fun Core(): Pack = Pack(id = "core",
            name = "Core Set",
            position = 1,
            releasedAt = LocalDate.parse("2017-10-05"),
            size = 350,
            cycle = TestCycles.Core(),
            ffgId = "L5C01")
}
