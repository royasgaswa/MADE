package com.example.moviecatalogue.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

@ExperimentalCoroutinesApi
class MovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    private val viewModel: MovieViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadKoinModules(movieModule)
        if (activity != null) {
            val movieAdapter = com.example.moviecatalogue.base.presentation.adapter.MovieAdapter()
            progress_bar.visibility = View.VISIBLE
            viewModel.getMovies()
            viewModel.movie.observe(viewLifecycleOwner, Observer{ movie->
                if (movie!=null){
                    pg_empty.visibility=View.GONE
                    movieAdapter.setData(movie)
                    movieAdapter.notifyDataSetChanged()
                    rv_movie.scheduleLayoutAnimation()
                }else{
                    pg_empty.visibility=View.VISIBLE
                }

            })
            viewModel.isLoading.observe(viewLifecycleOwner, Observer{ state ->
                if (!state) {
                    progress_bar.visibility = View.GONE
                }

            })



            with(rv_movie) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }
}