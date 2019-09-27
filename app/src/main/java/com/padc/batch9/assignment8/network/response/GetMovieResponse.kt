package com.padc.batch9.assignment8.network.response

import com.google.gson.annotations.SerializedName
import com.padc.batch9.assignment8.data.vo.MovieVo
import com.padc.batch9.assignment8.util.CODE_RESPONSE_OK

class GetMovieResponse (
    @SerializedName("code")
     var code: Int,
    @SerializedName("message")
     var message: String,
    @SerializedName("data")
     var data: List<MovieVo>)

{
    fun isResponseOK(): Boolean{
        return code == CODE_RESPONSE_OK && data!= null
    }
}