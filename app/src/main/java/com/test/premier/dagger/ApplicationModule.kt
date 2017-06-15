package com.test.premier.dagger

import android.content.Context
import com.test.premier.PremierApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val app: PremierApp){

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return app.applicationContext
    }

}