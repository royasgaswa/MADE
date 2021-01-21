package com.example.moviecatalogue.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moviecatalogue.favorite.adapter.SectionsPagerAdapter
import com.example.moviecatalogue.favorite.di.favoriteModule
import kotlinx.android.synthetic.main.fragment_favorite.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.core.context.loadKoinModules

@ExperimentalCoroutinesApi
class FavoriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadKoinModules(favoriteModule)
        val sectionsPagerAdapter =
            SectionsPagerAdapter(this, requireActivity().supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)


    }

    override fun onDestroyView() {
        view_pager?.let {
            it.adapter=null
        }
        super.onDestroyView()
    }
}