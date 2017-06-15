package com.test.premier.dagger

import com.test.premier.interactor.MoviesInteractor
import com.test.premier.ui.MainActivityPresenter
import com.test.premier.ui.MainActivityPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class PresenterModule{

    @Provides
    fun providesMainActivityPresenter(interactor: MoviesInteractor) : MainActivityPresenter{
        return MainActivityPresenterImpl(interactor)
    }
}