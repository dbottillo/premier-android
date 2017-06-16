package com.test.premier.ui

import com.test.premier.domain.Movie
import com.test.premier.interactor.MoviesInteractor
import io.reactivex.disposables.Disposable

class MainActivityPresenterImpl(val interactor: MoviesInteractor): MainActivityPresenter {

    lateinit var view: MainActivityView

    var disposable: Disposable? = null

    override fun init(view: MainActivityView) {
        this.view = view
    }

    override fun requestTopMovies() {
        view.showLoading()
        disposable = interactor.requestTopMovies().subscribe (
            { movies -> onSuccess(movies) },
            { _ -> onError() }
        )
    }

    fun onSuccess(movies: List<Movie>) {
        view.hideLoading()
        view.showMovies(movies)
    }

    fun onError() {
        view.hideLoading()
        view.showImpossibileToFetchMovies()
    }

   override fun onDestroy(){
        disposable?.dispose()
    }
}