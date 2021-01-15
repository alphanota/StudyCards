package com.montero.studycards.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.montero.studycards.db.models.Card

@Dao
abstract class CardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun create(cards: List<Card>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun create(card: Card)

    @Query("""SELECT * from ${Card.TABLE_NAME}""")
    abstract fun list() :LiveData<List<Card>>

    @Query("""SELECT * from ${Card.TABLE_NAME} where id = :id LIMIT 1""")
    abstract fun retrieve(id: String) :LiveData<Card>

}