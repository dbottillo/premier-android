package com.test.premier.network

import io.reactivex.Observable


class MoviesClientImpl(val service: TheMovieDbService) : MoviesClient {

    override fun requestTopMovies(): Observable<MoviesResponse> {
        return service.getTopRatedMovies()
    }

}