package com.padc.batch9.assignment8.data.model


import com.padc.batch9.assignment8.network.dataagent.MovieDataAgent
import com.padc.batch9.assignment8.network.dataagent.RetrofitAgent

abstract class BaseModel {
    protected val dataAgent: MovieDataAgent=RetrofitAgent

}