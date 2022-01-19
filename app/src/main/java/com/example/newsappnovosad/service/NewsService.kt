package com.example.newsappnovosad.service

import com.example.newsappnovosad.common.Common
import com.example.newsappnovosad.model.WebSite
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET(value = "everything")
    suspend fun getArticles(
        @Query("q") q: String = "Apple",
        @Query("sortBy") sortBy: String = "popularity",
        @Query("apiKey") apiKey: String = Common.API_KEY
    ): Response<WebSite>
}