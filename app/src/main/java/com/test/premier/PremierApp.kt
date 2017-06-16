package com.test.premier

import android.app.Application
import com.test.premier.dagger.AppComponent
import com.test.premier.dagger.ApplicationModule
import com.test.premier.dagger.DaggerAppComponent

class PremierApp : Application() {

    companion object{
        val BASE_SERVER_URL = "https://api.themoviedb.org/3/"
        val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w342"
    }

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

}