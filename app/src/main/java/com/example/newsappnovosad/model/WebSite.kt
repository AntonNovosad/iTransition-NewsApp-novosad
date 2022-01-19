package com.example.newsappnovosad.model

data class WebSite(
    val status: String?,
    val totalResult: String?,
    val articles: List<Article>?
)