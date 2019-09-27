package com.padc.batch9.assignment8.data.vo

import com.google.gson.annotations.SerializedName

data class GenreVo(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
) {
}