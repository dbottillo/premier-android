package com.test.premier.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.test.premier.R
import com.test.premier.domain.Movie

class MoviesAdapter(val movies: List<Movie>) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.title.text = movies[position].title
        holder.overview.text = movies[position].text
        holder.image.contentDescription = movies[position].title
        Glide.with(holder.itemView.context).load(movies[position].image).into(holder.image)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false))
    }
}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title = itemView.findViewById(R.id.movie_title) as TextView
    val image = itemView.findViewById(R.id.movie_image) as ImageView
    val overview = itemView.findViewById(R.id.movie_overview) as TextView
}