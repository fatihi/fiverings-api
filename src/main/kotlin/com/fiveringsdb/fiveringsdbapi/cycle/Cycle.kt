package com.fiveringsdb.fiveringsdbapi.cycle

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Cycle(
        @Id var id: String,
        var name: String,
        var position: Int,
        var size: Int)


