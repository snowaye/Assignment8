package com.padc.batch9.assignment8.network.dataagent


import com.padc.batch9.assignment8.data.vo.MovieVo
import com.padc.batch9.assignment8.network.MovieApi
import com.padc.batch9.assignment8.network.response.GetMovieResponse
import com.padc.batch9.assignment8.util.BASE_URL
import com.padc.batch9.assignment8.util.EM_NULL_EVENT_RESPONSE
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitAgent:MovieDataAgent {
    private val movieApi:MovieApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        movieApi = retrofit.create(MovieApi::class.java)
    }

    override fun getMovie(onSuccess: (List<MovieVo>) -> Unit, onFailure: (String) -> Unit) {
        val call = movieApi.getMovies()
        call.enqueue(object  : Callback<GetMovieResponse> {
            override fun onFailure(call: Call<GetMovieResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetMovieResponse>,
                response: Response<GetMovieResponse>
            ) {
                val movieResponse = response.body()
                if (movieResponse != null){
                    if(movieResponse.data != null){
                        onSuccess(movieResponse.data)
                    }else{
                        onFailure(movieResponse.message)
                    }
                }else{
                    onFailure(EM_NULL_EVENT_RESPONSE)
                }
            }
        })
    }
}