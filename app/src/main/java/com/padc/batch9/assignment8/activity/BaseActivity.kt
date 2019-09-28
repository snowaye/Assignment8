package com.padc.batch9.assignment8.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.padc.batch9.assignment8.data.model.MovieModel
import com.padc.batch9.assignment8.data.model.MovieModelImpl

abstract class BaseActivity: AppCompatActivity() {
    protected lateinit var model: MovieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = MovieModelImpl
    }
}