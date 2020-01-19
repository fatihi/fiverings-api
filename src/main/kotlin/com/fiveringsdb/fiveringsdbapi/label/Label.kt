package com.fiveringsdb.fiveringsdbapi.label

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Label(
        @Id
        var id: String,
        var value: String)
