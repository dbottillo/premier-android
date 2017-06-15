package com.test.premier.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.test.premier.PremierApp

import com.test.premier.R
import com.test.premier.dagger.DaggerUIComponent
import com.test.premier.domain.Movie
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityView {

    private val TOP_RATED = "https://api.themoviedb.org/3/movie/top_rated?api_key=e4f9e61f6ffd66639d33d3dde7e3159b"

    @Inject
    lateinit var presenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uiComponent = DaggerUIComponent.builder().appComponent((application as PremierApp).appComponent).build()
        uiComponent.inject(this)
        presenter.init(this)

        presenter.requestTopMovies()
    }

    override fun onDestroy() {
        super.onDestroy()

        presenter.onDestroy()
    }

    override fun showLoading() {
        Log.e("PremierApp", "showLoading") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMovies(movies: List<Movie>) {
        Log.e("PremierApp", "movies $movies") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        Log.e("PremierApp", "hideLoading") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showImpossibileToFetchMovies() {
        Log.e("PremierApp", "showLoading") //To change body of created functions use File | Settings | File Templates.
    }
}
