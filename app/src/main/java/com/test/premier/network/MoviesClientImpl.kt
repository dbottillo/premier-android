package com.test.premier.network

import rx.Observable

class MoviesClientImpl(val service: TheMovieDbService) : MoviesClient {

    override fun requestTopMovies(): Observable<MoviesResponse> {
        return service.getTopRatedMovies()
    }

}