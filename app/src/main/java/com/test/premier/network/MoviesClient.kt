package com.test.premier.network

import io.reactivex.Observable

interface MoviesClient {
    fun requestTopMovies(): Observable<MoviesResponse>
}