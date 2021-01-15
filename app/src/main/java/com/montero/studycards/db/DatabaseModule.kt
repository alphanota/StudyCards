package com.montero.studycards.db

import android.app.Application
import androidx.room.Room
import com.montero.studycards.db.dao.CardDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun providesCardsDb(app: Application) : CardsDb {
        return Room
            .databaseBuilder(app, CardsDb::class.java, "study_cards.db")
            .createFromAsset("example_data.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideCardDao(db: CardsDb) : CardDao {
        return db.cardDao()
    }
}