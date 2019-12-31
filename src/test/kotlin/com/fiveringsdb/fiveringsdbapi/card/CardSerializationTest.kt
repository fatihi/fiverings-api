package com.fiveringsdb.fiveringsdbapi.card

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class CardSerializationTest {

    @Autowired
    lateinit var springMvc: MockMvc

    @MockkBean
    lateinit var controllerMock: CardsController

    private val testCards: List<Card> = listOf(Card(id = "way-of-the-phoenix", name = "Way of the Phoenix", type = CardType.Event,
                            clan = Clan.Phoenix, isUnique = false, side = Side.Conflict, traits = listOf("philosophy"),
                            deckLimit = 3, isRestricted = false, allowedClans = listOf(Clan.Phoenix), isBanned = false,
                            nameExtra = null, cost = "0", text = "<b>Action:</b> Choose a ring and an opponent - that " +
                            "player cannot declare conflicts of that ring's element this phase. (Max 1 per phase.)",
                            element = null, fate = null, glory = null, honor = null, influenceCost = null, influencePool = null,
                            military = null, militaryBonus = null, political = null, politicalBonus = null, roleRestriction = null,
                            strength = null, strengthBonus = null))

    @Test
    fun `serializes the card correctly`() {
        every { controllerMock.getCards() } returns testCards

        val result = springMvc.perform(MockMvcRequestBuilders.get("/cards"))
                                .andExpect(status().isOk)
                                .andReturn().response.contentAsString

        val expected = object {}.javaClass.getResource("/card/way-of-the-phoenix.json").readText(Charsets.UTF_8)
        assertEquals(result, expected)

    }
}
