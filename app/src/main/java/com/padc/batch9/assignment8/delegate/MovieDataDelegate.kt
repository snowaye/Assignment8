package com.padc.batch9.assignment8.delegate

import com.padc.batch9.assignment8.data.vo.MovieVo

interface MovieDataDelegate {
    fun getMovieListFromHost():List<MovieVo>
}