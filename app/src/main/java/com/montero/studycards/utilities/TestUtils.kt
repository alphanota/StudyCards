package com.montero.studycards.utilities

import com.montero.studycards.db.models.Card
import java.util.*

val uuids = arrayOf(
    UUID.fromString("979d3d83-44b1-4d9c-91ff-64e541fcedb8"),
    UUID.fromString("616a6eed-230c-461d-9c1f-e77002922d4f"),
    UUID.fromString("a4595dfa-d31e-4812-a1fc-0cfaf6348981")
)


val testCards = arrayListOf(
    Card(uuids[0], "USA", "Washington, D.C." ),
    Card(uuids[1], "London", "England" ),
    Card(uuids[2], "New Delhi", "India" )
)

val testCard = testCards[0]