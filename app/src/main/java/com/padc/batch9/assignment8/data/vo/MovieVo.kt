package com.padc.batch9.assignment8.data.vo
import com.google.gson.annotations.SerializedName

data class MovieVo(
    @SerializedName("id")
    var id: Int,

    @SerializedName("movie_name")
    var movieName: String,

    @SerializedName("imdb")
    var imdb: Double,

    @SerializedName("rotten_tomato")
    var rottenTomato: Int,

    @SerializedName("meta_centric")
    var metaCentric: Int,

    @SerializedName("genre")
    var genre: List<GenreVo>,

//    private var genreStringList: MutableList<String>,

    @SerializedName("overview")
    var overview: String,

    @SerializedName("poster")
    var poster: String
) {

    fun getGenreStringList():List<String> {
        val genreStringList:List<String> = ArrayList<String>()
        for (temp in genre) {
            genreStringList.toMutableList().add(temp.name)
        }
        return genreStringList
    }
}