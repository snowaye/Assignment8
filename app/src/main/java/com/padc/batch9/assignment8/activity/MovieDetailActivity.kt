package com.padc.batch9.assignment8.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.padc.batch9.assignment8.R

class MovieDetailActivity : AppCompatActivity() {

    companion object {
        const val IE_MOVIE_ID = "id"

        fun newIntent(context: Context, id: Int): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(IE_MOVIE_ID, id)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
    }
}
