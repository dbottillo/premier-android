package com.test.premier.network

import retrofit2.http.GET
import rx.Observable

interface TheMovieDbService{

    @GET("/movie/top_rated")
    fun getTopRatedMovies(): Observable<MoviesResponse>
}