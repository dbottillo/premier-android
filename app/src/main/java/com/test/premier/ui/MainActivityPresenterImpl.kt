package com.test.premier.ui

import com.test.premier.domain.Movie
import com.test.premier.interactor.MoviesCallback
import com.test.premier.interactor.MoviesInteractor
import io.reactivex.disposables.Disposable

class MainActivityPresenterImpl(val interactor: MoviesInteractor): MainActivityPresenter, MoviesCallback {

    lateinit var view: MainActivityView

    var disposable: Disposable? = null

    override fun init(view: MainActivityView) {
        this.view = view
    }

    override fun requestTopMovies() {
        view.showLoading()
        disposable = interactor.requestTopMovies(this)
    }

    override fun onSuccess(movies: List<Movie>) {
        view.hideLoading()
        view.showMovies(movies)
    }

    override fun onError() {
        view.hideLoading()
        view.showImpossibileToFetchMovies()
    }

    fun onDestroy(){
        disposable?.dispose()
    }
}