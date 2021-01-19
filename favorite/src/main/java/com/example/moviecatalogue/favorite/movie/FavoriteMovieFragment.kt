package com.example.moviecatalogue.favorite.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviecatalogue.favorite.R
import kotlinx.android.synthetic.main.fragment_favorite_movie.*
import org.koin.android.viewmodel.ext.android.viewModel


class FavoriteMovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_movie, container, false)
    }

    private val viewModel: FavoriteMovieViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val movieFavoriteAdapter =
                com.example.moviecatalogue.base.presentation.adapter.MovieAdapter()
            progress_bar.visibility = View.VISIBLE
            viewModel.getFavoriteMovies()
            viewModel.isLoading.observe(viewLifecycleOwner, Observer{ state->
                if (!state){
                    progress_bar.visibility=View.GONE
                }
            })
            viewModel.movie.observe(viewLifecycleOwner, Observer{
                progress_bar.visibility = View.GONE
                movieFavoriteAdapter.setData(it)
                movieFavoriteAdapter.notifyDataSetChanged()
                rv_favorite_movie.scheduleLayoutAnimation()
            })
            with(rv_favorite_movie) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = movieFavoriteAdapter
            }
        }
    }
}