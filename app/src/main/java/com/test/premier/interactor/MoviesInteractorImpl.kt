package com.test.premier.interactor

import com.test.premier.domain.Movie
import com.test.premier.network.MoviesClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class MoviesInteractorImpl(val client: MoviesClient) : MoviesInteractor {


    override fun requestTopMovies(callback: MoviesCallback): Disposable {
        return client.requestTopMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { moviesresponse -> listOf<Movie>() }
                .subscribe(
                        { movies -> callback.onSuccess(movies) },
                        { throwable -> callback.onError() }
                )
    }

}