package com.test.premier.ui

import com.test.premier.domain.Movie

interface MainActivityView {
    fun showLoading()
    fun showMovies(movies: List<Movie>)
    fun hideLoading()
    fun showImpossibileToFetchMovies()
}