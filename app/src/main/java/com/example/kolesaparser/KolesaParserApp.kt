package com.example.kolesaparser

import android.app.Application
import carDatabaseModule
import mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin

class KolesaParserApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@KolesaParserApp)
            modules(carDatabaseModule, mainModule)
        }
    }
}