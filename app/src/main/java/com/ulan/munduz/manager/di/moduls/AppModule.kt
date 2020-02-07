package com.ulan.munduz.manager.di.moduls

import android.content.Context
import com.ulan.munduz.manager.MainApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: MainApplication): Context {
        return application
    }
}