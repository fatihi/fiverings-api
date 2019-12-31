package com.fiveringsdb.fiveringsdbapi.card

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringExtensionsTest {

    @Test
    fun `test toCanonical for way of the phoenix`() {
        val text = "<b>Action:</b> Choose a ring and an opponent - that player cannot declare conflicts " +
                "of that ring's element this phase. (Max 1 per phase.)"
        val expected = "action: choose a ring and an opponent - that player cannot declare conflicts " +
                "of that ring's element this phase. (max 1 per phase.)"

        assertEquals(text.toCanonical(), expected)
    }

    @Test
    fun `test toCanonical for wildfire kick`() {
        val text = "<b>Action:</b> During a conflict in which you have played 3 or more cards, choose a participating " +
                "<em>Monk</em> character you control - each participating character your opponent controls with " +
                "[conflict-military] skill equal to or lower than the chosen character gets -2[conflict-military] " +
                "and -2[conflict-political] until the end of the conflict."
        val expected = "action: during a conflict in which you have played 3 or more cards, choose a participating " +
                "monk character you control - each participating character your opponent controls with " +
                "[conflict-military] skill equal to or lower than the chosen character gets -2[conflict-military] " +
                "and -2[conflict-political] until the end of the conflict."

        assertEquals(text.toCanonical(), expected)
    }
}