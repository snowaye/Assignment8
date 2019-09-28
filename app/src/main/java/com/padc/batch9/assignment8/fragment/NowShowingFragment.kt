package com.padc.batch9.assignment8.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.padc.batch9.assignment8.R
import com.padc.batch9.assignment8.activity.MovieDetailActivity
import com.padc.batch9.assignment8.data.vo.MovieVo
import com.padc.batch9.assignment8.delegate.MovieItemDelegate

class NowShowingFragment:Fragment(), MovieItemDelegate {

    var list:List<MovieVo> = ArrayList<MovieVo>()
    lateinit var movieDelegate:MovieItemDelegate

    override fun onTapItemEvent(id: Int) {
        val intent = this.context?.let { MovieDetailActivity.newIntent(it, id) }
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_now_showing, container, false)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        movieDelegate = context
    }
}