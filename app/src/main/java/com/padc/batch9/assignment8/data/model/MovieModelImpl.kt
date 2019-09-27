package com.padc.batch9.assignment8.data.model

import com.padc.batch9.assignment8.data.vo.MovieVo

object MovieModelImpl:BaseModel(), MovieModel{

    private lateinit var movieDataRepository:Map<Int, MovieVo>

    override fun getMovie(onSuccess: (List<MovieVo>) -> Unit, onFailure: (String) -> Unit) {
//        for (item in listOf(onSuccess).iterator()) {
//            movieDataRepository
//        }

        dataAgent.getMovie(
            {
                movieDataRepository = it.map { it.id to it }.toMap()
                onSuccess(it)
        },
            onFailure)

    }

    override fun getMovieById(id: Int): MovieVo? {
        movieDataRepository.let { return it.get(id) }
    }
}