package com.padc.batch9.assignment8.network

import com.padc.batch9.assignment8.network.response.GetMovieResponse
import com.padc.batch9.assignment8.util.GET_MOVIE
import retrofit2.Call
import retrofit2.http.POST

interface MovieApi {
    @POST(GET_MOVIE)
    fun getMovies(): Call<GetMovieResponse>
}