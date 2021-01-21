package com.example.moviecatalogue.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviecatalogue.favorite.R
import kotlinx.android.synthetic.main.fragment_favorite_tvshow.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel


@ExperimentalCoroutinesApi
class FavoriteTvShowFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_tvshow, container, false)
    }

    private val viewModel: FavoriteTvShowViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val tvshowFavoriteAdapter =
                com.example.moviecatalogue.base.presentation.adapter.TvshowAdapter()
            progress_bar.visibility = View.VISIBLE
            viewModel.getFavoriteTvShow()
            viewModel.isLoading.observe(viewLifecycleOwner, Observer{ state->
                if (!state){
                    progress_bar.visibility=View.GONE
                }
            })
            viewModel.tvShows.observe(viewLifecycleOwner, Observer{

                if (it.isNotEmpty()){
                    pg_empty.visibility=View.VISIBLE
                    tvshowFavoriteAdapter.setData(it)
                    tvshowFavoriteAdapter.notifyDataSetChanged()
                    rv_favorite_tvshow.scheduleLayoutAnimation()
                }else{
                    pg_empty.visibility=View.VISIBLE
                }

            })


            with(rv_favorite_tvshow) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = tvshowFavoriteAdapter
            }
        }
    }
}