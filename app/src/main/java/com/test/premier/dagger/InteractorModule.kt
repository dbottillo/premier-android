package com.test.premier.dagger

import com.test.premier.interactor.MoviesInteractor
import com.test.premier.interactor.MoviesInteractorImpl
import com.test.premier.network.MoviesClient
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {

    @Provides
    fun providesMoviesInteractor(client: MoviesClient): MoviesInteractor {
        return MoviesInteractorImpl(client)
    }
}