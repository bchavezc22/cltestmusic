package com.test.cl.claratest.remote

import com.test.cl.claratest.data.ArtistDetail
import com.test.cl.claratest.data.ArtistSearchResponse
import com.test.cl.claratest.data.ReleasesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DiscogsApiService {

    @GET("database/search?type=artist")
    suspend fun searchArtists(@Query("q") query: String, @Query("token") tokenApi: String): ArtistSearchResponse

    @GET("artists/{artistId}")
    suspend fun getArtistDetail(@Path("artistId") artistId: Int): ArtistDetail

    @GET("artists/{artistId}/releases")
    suspend fun getArtistReleases(@Path("artistId") artistId: Int): ReleasesResponse
}