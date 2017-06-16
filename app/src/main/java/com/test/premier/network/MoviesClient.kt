package com.test.premier.network

import io.reactivex.Observable

interface MoviesClient {
    fun fetchTopMovies(): Observable<MoviesResponse>
}