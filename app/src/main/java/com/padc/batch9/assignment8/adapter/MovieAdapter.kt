package com.padc.batch9.assignment8.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.batch9.assignment8.R
import com.padc.batch9.assignment8.data.vo.MovieVo
import com.padc.batch9.assignment8.delegate.MovieItemDelegate
import com.padc.batch9.assignment8.view.holder.MovieViewHolder

class MovieAdapter(private val movieItemDelegate: MovieItemDelegate):BaseAdapter<MovieViewHolder, MovieVo>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listitem_movie, parent,
            false)
        return MovieViewHolder(view, movieItemDelegate)

    }
}