package com.padc.batch9.assignment8.data.model

import com.padc.batch9.assignment8.data.vo.MovieVo

interface MovieModel {
    fun getMovie(onSuccess:(List<MovieVo>) -> Unit,
                 onFailure:(String) -> Unit)

    fun getMovieById(id:Int):MovieVo?
}