package com.montero.studycards


import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * Necessary for hilt/dagger
 * When tagging an Application with @HiltAndroidApp - set the name attribute
 * of the application tag in androidmanifest.xml
 * ex.
 * <application
 *  name=".StudyCardApplication"
 */
@HiltAndroidApp
class StudyCardApplication: Application(), Configuration.Provider {


    @Inject lateinit var workerFactory: HiltWorkerFactory

    // Setup custom configuration for WorkManager with a DelegatingWorkerFactory
    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}