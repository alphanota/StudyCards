package com.montero.studycards.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = Card.TABLE_NAME)
data class Card(
    @PrimaryKey
    val id: UUID,
    val front: String,
    val back: String

    ) {

    //using static var. TABLE_NAME to avoid hard coding
    // the table name
    companion object {
        const val TABLE_NAME = "cards"
    }
}