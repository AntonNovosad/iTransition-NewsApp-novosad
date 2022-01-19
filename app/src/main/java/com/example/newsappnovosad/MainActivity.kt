package com.example.newsappnovosad

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsappnovosad.adapter.ListSourceAdapter
import com.example.newsappnovosad.databinding.ActivityMainBinding
import com.example.newsappnovosad.service.NewsService
import com.example.newsappnovosad.ui.login.LoginActivity


class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()
    lateinit var layoutManager: LinearLayoutManager
    lateinit var mService: NewsService
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: ListSourceAdapter
    lateinit var dialog: AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //login
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.loginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        //Init
        adapter = ListSourceAdapter(this)
        layoutManager = LinearLayoutManager(this)
        binding.mainIdNews.adapter = adapter
        binding.mainIdNews.layoutManager = layoutManager

        viewModel.articles.observe(this) {
            adapter.submitList(it)
        }
        viewModel.errors.observe(this) { errorText ->
            Toast.makeText(this, errorText, Toast.LENGTH_SHORT).show()
        }
    }
}