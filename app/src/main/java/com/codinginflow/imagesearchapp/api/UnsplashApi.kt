package com.codinginflow.imagesearchapp.api

import com.codinginflow.imagesearchapp.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

// Interface because Retrofit will generate implementation later?

interface UnsplashApi {
    companion object {
        const val BASE_URL = "https://api.unsplash.com/"
        const val CLIENT_ID = BuildConfig.UNSPLASH_ACCESS_KEY
    }

    // Suspend functions are only allowed to be called from a coroutine or another suspend function
    // Suspended function can be paused and can be continued later without blocking the thread

    @Headers("Accept-Version: v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): UnsplashResponse
}