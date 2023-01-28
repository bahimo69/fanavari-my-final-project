package bahi.moein.omdb.data.remote.api

import bahi.moein.omdb.def.Const
import bahi.moein.omdb.data.model.detail.DetailResponse
import bahi.moein.omdb.data.model.response.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Baharm MoeinPour <bahi2034@gmail.com>
 */

/**
 * Apis for fetching data drom OMDB
 */

interface OmdbiService {
    @GET(Const.OMDB_API_URL)
    suspend fun getPosts(
        @Query("s") s: String?,
        @Query("apikey") apikey: String?,
        @Query("type") type: String?,
        @Query("page") page: Int?
    ): Response<SearchResponse>

    @GET(Const.OMDB_API_URL)
    suspend fun getDetailPosts(
        @Query("apikey") apikey: String?,
        @Query("i") i: String?
    ): Response<DetailResponse>


}
