package com.fiveringsdb.fiveringsdbapi.card

import org.springframework.data.repository.CrudRepository

interface CardsRepository : CrudRepository<Card, String>
