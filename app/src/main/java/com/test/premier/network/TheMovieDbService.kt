package com.test.premier.network

import io.reactivex.Observable
import retrofit2.http.GET

interface TheMovieDbService{

    @GET("/movie/top_rated")
    fun getTopRatedMovies(): Observable<MoviesResponse>
}