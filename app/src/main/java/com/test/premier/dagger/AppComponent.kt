package com.test.premier.dagger

import com.test.premier.interactor.MoviesInteractor
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, NetworkModule::class, InteractorModule::class))
interface AppComponent {

    fun providesMoviesInteractor(): MoviesInteractor
}
