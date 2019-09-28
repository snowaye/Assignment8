package com.padc.batch9.assignment8.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.padc.batch9.assignment8.R
import com.padc.batch9.assignment8.data.vo.MovieVo
import com.padc.batch9.assignment8.util.FunUtil
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.listitem_movie.*
import kotlinx.android.synthetic.main.listitem_movie.tv_genre
import kotlinx.android.synthetic.main.listitem_movie.tv_movie_name

class MovieDetailActivity : BaseActivity() {

    companion object {
        const val IE_MOVIE_ID = "id"

        fun newIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(IE_MOVIE_ID, id)
            return intent
        }
    }

     var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        FunUtil.setStatusBarColor(this, R.color.textColorMain)
        id = intent.getIntExtra(IE_MOVIE_ID, -1)
        val movieVo = model.getMovieById(id)
        if (movieVo != null) {
            tv_movie_name.text = movieVo.movieName
            tv_genre.text = movieVo.genre.toString()
            tv_imdb.text = movieVo.imdb.toString()
            tv_rotten_tomato_detail.text = movieVo.rottenTomato.toString()
            tv_meta_centric_detail.text =movieVo.metaCentric.toString()
            Glide.with(this).load(movieVo.poster).into(imgv_movie_detail)
            tv_overview.setText(movieVo.overview)
        }
        imgv_close.setOnClickListener(View.OnClickListener { finish() })
    }
}
