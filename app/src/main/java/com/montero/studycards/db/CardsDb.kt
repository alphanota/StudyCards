package com.montero.studycards.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.montero.studycards.db.dao.CardDao
import com.montero.studycards.db.models.Card

@Database(
    entities = [
        Card::class
    ],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class CardsDb: RoomDatabase() {
    abstract fun cardDao(): CardDao
}