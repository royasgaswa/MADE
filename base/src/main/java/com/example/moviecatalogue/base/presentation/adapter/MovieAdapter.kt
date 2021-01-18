package com.example.moviecatalogue.base.presentation.adapter

import android.app.ActivityOptions
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.moviecatalogue.base.R
import com.example.moviecatalogue.base.presentation.CastedContex
import com.example.moviecatalogue.base.presentation.model.MovieEntityPresentation
import kotlinx.android.synthetic.main.items_movie.view.*


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var listData=ArrayList<MovieEntityPresentation>()

    fun setData(newListData:List<MovieEntityPresentation>?){
        if(newListData == null)return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return MovieViewHolder(view)
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)

    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        companion object {
            const val EXTRA_MOVIE = "extra_movie"
        }
        fun bind(movie: MovieEntityPresentation) {
            with(itemView) {
                tv_title_movie.text = movie.title
                tv_movie_rating.text = movie.rate
                setOnClickListener {
                    val intent = Intent(context, Class.forName("com.example.moviecatalogue.detail.DetailMovieActivity")).apply {
                        putExtra(EXTRA_MOVIE, movie.id)
                    }
                    val option = ActivityOptions.makeSceneTransitionAnimation(
                        CastedContex.scanForActivity(context),
                        img_movie_photo,
                        resources.getString(R.string.sharedView)
                    )
                    context.startActivity(intent, option.toBundle())
                }
                Glide.with(context)
                    .load("https://image.tmdb.org/t/p/w500/"+movie.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(img_movie_photo)
            }
        }

    }

    override fun getItemCount(): Int =listData.size
}