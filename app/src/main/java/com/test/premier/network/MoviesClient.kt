package com.test.premier.network

import rx.Observable

interface MoviesClient {
    fun requestTopMovies(): Observable<MoviesResponse>
}