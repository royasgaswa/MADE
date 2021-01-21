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
import com.example.moviecatalogue.base.presentation.model.TvShowEntityPresentation
import com.example.moviecatalogue.detail.animation.SharedElementViewProvider
import com.example.moviecatalogue.detail.di.tvShowModule
import com.example.moviecatalogue.detail.viewmodel.DetailTvShowViewModel
import kotlinx.android.synthetic.main.activity_detail_tvshow.*
import kotlinx.android.synthetic.main.rate_star.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

@ExperimentalCoroutinesApi
class DetailTvShowActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    private val viewModel: DetailTvShowViewModel by viewModel()
    private var menu: Menu? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        SharedElementViewProvider(
            window
        ).init()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tvshow)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        loadKoinModules(tvShowModule)
        val extras = intent.extras
        progress_bar.visibility = View.VISIBLE
        if (extras != null) {
            val tvshowId = extras.getInt(EXTRA_TVSHOW)
            viewModel.setSelectedTvshow(tvshowId)
            viewModel.getDetailTvshow()
            viewModel.isLoading.observe(this, Observer{ state->
                if (!state){
                    progress_bar.visibility=View.GONE
                }
            })
            viewModel.tvShow.observe(this, Observer{
                populateTvshow(it)
            })
        }
    }

    fun populateTvshow(tvShow: TvShowEntityPresentation) {
        Log.d("tes", tvShow.firstAirDate + " " + tvShow.name)
        tv_title_tvshow.text = tvShow.name
        date_tvshow.text = tvShow.firstAirDate

        rating.text = tvShow.rate.toString()
        tv_content_tvshow.text = tvShow.overview
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/"+tvShow.backdropPath)
            .apply(
                RequestOptions.placeholderOf(com.example.moviecataloge.R.drawable.ic_loading)
                    .error(com.example.moviecataloge.R.drawable.ic_error)
            )
            .into(img_tvshow_main)
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/"+tvShow.posterPath)
            .apply(
                RequestOptions.placeholderOf(com.example.moviecataloge.R.drawable.ic_loading)
                    .error(com.example.moviecataloge.R.drawable.ic_error)
            )
            .into(img_tvshow_second)
        val state=tvShow.isFavorite
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