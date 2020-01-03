package com.fiveringsdb.fiveringsdbapi.cycle

object TestCycles {
  fun ClanPacksCycle(): Cycle = Cycle(id = "clan-packs", name = "Clan Packs", position = 2, size = 7)

  fun ImperialCycle(): Cycle = Cycle(id = "imperial", name = "Imperial Cycle", position = 4, size = 6)

  fun Core(): Cycle = Cycle(id = "core", name = "Core Set", position = 1, size = 1)
}
