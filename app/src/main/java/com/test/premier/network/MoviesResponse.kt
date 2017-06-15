package com.test.premier.network

class MoviesResponse(val page: Int, val total_results: Int, val total_pages: Int, val results: List<MovieResponse>)

class MovieResponse(val id: String, val title: String, val backdrop_path: String, val overview: String, val release_date: String)