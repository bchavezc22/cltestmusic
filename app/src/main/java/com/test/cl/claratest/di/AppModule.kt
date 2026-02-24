package com.test.cl.claratest.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.test.cl.claratest.data.repository.ArtistRepositoryImpl
import com.test.cl.claratest.domain.repository.ArtistRepository
import com.test.cl.claratest.domain.usecase.GetArtistDetailUseCase
import com.test.cl.claratest.domain.usecase.GetArtistReleasesUseCase
import com.test.cl.claratest.domain.usecase.SearchArtistsUseCase
import com.test.cl.claratest.remote.DiscogsApiService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object AppModule {

    private const val BASE_URL = "https://api.discogs.com/"

    private val moshi: Moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    private val discogsApiService: DiscogsApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(DiscogsApiService::class.java)
    }

    val artistRepository: ArtistRepository by lazy {
        ArtistRepositoryImpl(discogsApiService)
    }

    val searchArtistsUseCase: SearchArtistsUseCase by lazy {
        SearchArtistsUseCase(artistRepository)
    }

    val getArtistDetailUseCase: GetArtistDetailUseCase by lazy {
        GetArtistDetailUseCase(artistRepository)
    }

    val getArtistReleasesUseCase: GetArtistReleasesUseCase by lazy {
        GetArtistReleasesUseCase(artistRepository)
    }
}