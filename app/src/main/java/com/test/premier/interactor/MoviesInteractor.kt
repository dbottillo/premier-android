package com.test.premier.interactor

import com.test.premier.domain.Movie
import io.reactivex.Observable

interface MoviesInteractor {
    fun requestTopMovies(): Observable<List<Movie>>
}
