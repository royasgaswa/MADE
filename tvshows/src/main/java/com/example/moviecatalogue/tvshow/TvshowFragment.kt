package com.example.moviecatalogue.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_tvshow.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class TvshowFragment : Fragment() {
    private val viewModel: TvshowViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvshow, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadKoinModules(tvshowModule)
        if (activity != null) {
            val tvshowAdapter = com.example.moviecatalogue.base.presentation.adapter.TvshowAdapter()
            progress_bar.visibility = View.VISIBLE
            viewModel.getTvshow()
            viewModel.isLoading.observe(viewLifecycleOwner,{state->
                if (!state){
                    progress_bar.visibility=View.GONE
                }
            })
            viewModel.tvshow.observe(viewLifecycleOwner,{
                tvshowAdapter.setData(it)
                tvshowAdapter.notifyDataSetChanged()
                rv_tvshow.scheduleLayoutAnimation()
            })

            with(rv_tvshow) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = tvshowAdapter
            }
        }
    }
}