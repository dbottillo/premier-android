package com.test.premier.interactor

import com.test.premier.domain.Movie
import io.reactivex.disposables.Disposable
import rx.Subscription

interface MoviesInteractor {
    fun requestTopMovies(callback: MoviesCallback): Disposable
}

interface MoviesCallback {
    fun onSuccess(movies: List<Movie>)
    fun onError()
}