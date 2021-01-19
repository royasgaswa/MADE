package com.example.moviecatalogue.detail

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.detail.animation.SharedElementViewProvider
import com.example.moviecatalogue.detail.di.movieModule
import com.example.moviecatalogue.detail.viewmodel.DetailMovieViewModel
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.rate_star.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private val viewModel: DetailMovieViewModel by viewModel()
    private var menu: Menu? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        SharedElementViewProvider(
            window
        ).init()
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail_movie)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        loadKoinModules(movieModule)
        val extras = intent.extras
        progress_bar.visibility = View.VISIBLE
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE)
            viewModel.setSelectedMovie(movieId)
            viewModel.getDetailMovie()
            viewModel.isLoading.observe(this, Observer{ state->
                if (!state){
                    progress_bar.visibility=View.GONE
                }
            })
            viewModel.movie.observe(this, Observer{
                populateMovie(it)
            })
        }
    }

    fun populateMovie(movie: com.example.moviecatalogue.base.presentation.model.MovieEntityPresentation) {
        tv_title_movie.text = movie.title
        rating.text = movie.rate
        tv_date_movie.text = movie.releaseDate
        tv_content_movie.text = movie.overview
        Log.d("back", movie.backdropPath.toString())
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/"+movie.backdropPath)
            .apply(
                RequestOptions.placeholderOf(com.example.moviecataloge.R.drawable.ic_loading)
                    .error(com.example.moviecataloge.R.drawable.ic_error)
            )
            .into(img_movie_main)
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/"+movie.posterPath)
            .apply(
                RequestOptions.placeholderOf(com.example.moviecataloge.R.drawable.ic_loading)
                    .error(com.example.moviecataloge.R.drawable.ic_error)
            )
            .into(img_movie_photo)
        val state=movie.isFavorite
        setFavoriteState(state)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            viewModel.setFavorite()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, com.example.moviecataloge.R.drawable.ic_favorite)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, com.example.moviecataloge.R.drawable.ic_unfavorite)
        }
    }
}