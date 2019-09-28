package com.padc.batch9.assignment8.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.padc.batch9.assignment8.R
import com.padc.batch9.assignment8.activity.MovieDetailActivity
import com.padc.batch9.assignment8.adapter.MovieAdapter
import com.padc.batch9.assignment8.data.vo.MovieVo
import com.padc.batch9.assignment8.delegate.MovieDataDelegate
import com.padc.batch9.assignment8.delegate.MovieItemDelegate
import kotlinx.android.synthetic.main.fragment_now_showing.*

class CinemaFragment:Fragment(), MovieItemDelegate {

    var list:List<MovieVo> = ArrayList<MovieVo>()
    lateinit var movieDelegate:MovieDataDelegate

    override fun onTapItemEvent(id: Int) {
        val intent = this.context?.let { MovieDetailActivity.newIntent(it, id) }
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_cinema, container, false)
        val layoutManager:LinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recv_movie.layoutManager = layoutManager
        val adapter:MovieAdapter = MovieAdapter(this)
        adapter.setNewData(list.toMutableList())
        recv_movie.adapter = adapter
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        movieDelegate = context as MovieDataDelegate
        list = movieDelegate.getMovieListFromHost()
    }
}