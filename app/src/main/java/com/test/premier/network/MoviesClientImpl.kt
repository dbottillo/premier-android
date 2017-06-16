package com.test.premier.network

import io.reactivex.Observable


class MoviesClientImpl(val service: TheMovieDbService) : MoviesClient {

    override fun fetchTopMovies(): Observable<MoviesResponse> {
        return service.getTopRatedMovies()
    }

}