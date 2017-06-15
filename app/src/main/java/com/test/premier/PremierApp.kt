package com.test.premier

import android.app.Application
import com.test.premier.dagger.AppComponent
import com.test.premier.dagger.ApplicationModule
import com.test.premier.dagger.DaggerAppComponent

class PremierApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

}