package com.padc.batch9.assignment8.view.holder

import android.view.View
import com.bumptech.glide.Glide
import com.padc.batch9.assignment8.data.vo.MovieVo
import com.padc.batch9.assignment8.delegate.MovieItemDelegate
import kotlinx.android.synthetic.main.listitem_movie.view.*

class MovieViewHolder(itemView: View, private val delegate:MovieItemDelegate):BaseViewHolder<MovieVo>(itemView) {

    init {
        val id = data?.id
        data?.id?.let {id->
            delegate.onTapItemEvent(id)
        }
    }

    override fun bindData(data: MovieVo) {
        itemView.tv_movie_name.text = data.movieName
        itemView.tv_genre.text = data.genre.toString()
        itemView.tv_imdb.text = data.imdb.toString()
        itemView.tv_rotten_tomato.text = data.rottenTomato.toString()
        itemView.tv_meta_centric.text = data.metaCentric.toString()
        Glide.with(itemView).load(data.poster).into(itemView.imgv_movie);
    }
}