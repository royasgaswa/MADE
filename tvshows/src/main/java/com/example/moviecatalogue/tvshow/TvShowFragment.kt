package com.example.moviecatalogue.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_tvshow.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

@ExperimentalCoroutinesApi
class TvShowFragment : Fragment() {
    private val viewModel: TvShowViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvshow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadKoinModules(tvShowModule)
        if (activity != null) {
            val tvshowAdapter = com.example.moviecatalogue.base.presentation.adapter.TvshowAdapter()
            progress_bar.visibility = View.VISIBLE
            viewModel.getTvShow()
            viewModel.isLoading.observe(viewLifecycleOwner, Observer{ state->
                if (!state){
                    progress_bar.visibility=View.GONE
                }
            })
            viewModel.tvShow.observe(viewLifecycleOwner, Observer{data->
                if (data!=null){
                    pg_empty.visibility=View.GONE
                    tvshowAdapter.setData(data)
                    tvshowAdapter.notifyDataSetChanged()
                    rv_tvshow.scheduleLayoutAnimation()
                }else{
                    pg_empty.visibility=View.VISIBLE
                }
            })

            with(rv_tvshow) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = tvshowAdapter
            }
        }
    }
}