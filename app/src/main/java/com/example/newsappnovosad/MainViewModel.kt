package com.example.newsappnovosad

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsappnovosad.common.Common
import com.example.newsappnovosad.model.Article
import kotlinx.coroutines.launch
import retrofit2.HttpException


class MainViewModel : ViewModel() {
    private val mService = Common.newsService
    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    private val _errors = MutableLiveData<String>()
    val errors: LiveData<String> = _errors

    init {
        viewModelScope.launch {
            val responce = mService.getArticles()
            if (responce.isSuccessful) {
                val list = responce.body()!!.articles!!
                val body = responce.body()
                _articles.postValue(list)
            } else {
                _errors.postValue("Error")
            }
        }
    }

}