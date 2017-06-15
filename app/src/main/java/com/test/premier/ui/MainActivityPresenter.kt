package com.test.premier.ui

interface MainActivityPresenter {
    fun init(view: MainActivityView)
    fun requestTopMovies()
    fun onDestroy()
}