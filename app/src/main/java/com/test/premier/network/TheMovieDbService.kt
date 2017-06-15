package com.test.premier.network

import io.reactivex.Observable
import retrofit2.http.GET

interface TheMovieDbService{

    @GET("movie/top_rated?api_key=e4f9e61f6ffd66639d33d3dde7e3159b")
    fun getTopRatedMovies(): Observable<MoviesResponse>
}