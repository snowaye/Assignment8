package com.padc.batch9.assignment8.network.dataagent

import com.padc.batch9.assignment8.data.vo.MovieVo

interface MovieDataAgent {

    fun getMovie(onSuccess:(List<MovieVo>) -> Unit, onFailure:(String) -> Unit)
}