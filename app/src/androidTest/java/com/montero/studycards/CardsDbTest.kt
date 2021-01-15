package com.montero.studycards

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.montero.studycards.db.CardsDb
import com.montero.studycards.db.dao.CardDao
import com.montero.studycards.utilities.getValue
import com.montero.studycards.utilities.testCard
import com.montero.studycards.utilities.testCards
import org.hamcrest.Matchers.equalTo
import org.junit.After
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class CardsDbTest {

    private lateinit var cardDao: CardDao
    private lateinit var db : CardsDb

    //to fix threading issues and deal
    // with liveData.observeForever()
    //used in getValue function
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule();

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, CardsDb::class.java).build()
        cardDao = db.cardDao()
        cardDao.create(testCards)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeCardsAndReadInList() {
        val card = getValue(cardDao.retrieve(testCard.id.toString()))
        assertThat(card, equalTo(testCard))
    }
}