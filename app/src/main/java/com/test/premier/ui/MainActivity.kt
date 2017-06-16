package com.test.premier.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import com.test.premier.PremierApp

import com.test.premier.R
import com.test.premier.dagger.DaggerUIComponent
import com.test.premier.domain.Movie
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityView {

    lateinit var loader: ProgressBar
    lateinit var list: RecyclerView

    @Inject
    lateinit var presenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loader = findViewById(R.id.loader) as ProgressBar
        list = findViewById(R.id.list) as RecyclerView

        list.setHasFixedSize(true)
        list.layoutManager = LinearLayoutManager(this)

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
        loader.visibility = View.VISIBLE
        list.visibility = View.INVISIBLE
    }

    override fun showMovies(movies: List<Movie>) {
        list.adapter = MoviesAdapter(movies)
    }

    override fun hideLoading() {
        loader.visibility = View.INVISIBLE
        list.visibility = View.VISIBLE
    }

    override fun showImpossibleToFetchMovies() {
        Toast.makeText(this, R.string.impossibile_load_movies, Toast.LENGTH_SHORT).show()
    }
}
