package com.fiveringsdb.fiveringsdbapi.card

fun String.toCanonical(): String =
    toLowerCase().replace(Regex("<[^>]*>"), "")
