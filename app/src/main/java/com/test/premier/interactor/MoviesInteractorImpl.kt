package com.test.premier.interactor

import com.test.premier.domain.Movie
import com.test.premier.network.MoviesClient
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MoviesInteractorImpl(val client: MoviesClient) : MoviesInteractor {

    override fun requestTopMovies(): Observable<List<Movie>> {
        return client.fetchTopMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map {
                    movies_response ->
                    movies_response.results.map {
                        Movie(it.title, it.overview, it.backdrop_path)
                    }
                }
    }

}