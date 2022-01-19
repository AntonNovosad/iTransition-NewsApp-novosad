package com.example.newsappnovosad.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsappnovosad.R
import com.example.newsappnovosad.model.Article

class ListSourceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: TextView = itemView.findViewById(R.id.news_id_TVNewsHeading)
    private val subTitle: TextView = itemView.findViewById(R.id.news_idSubTitle)
    private val image: ImageView = itemView.findViewById(R.id.news_id_IVNews)

    fun bind(article: Article, clickListener: () -> Unit) {
        title.text = article.title
        subTitle.text = article.description

        Glide.with(image.context)
            .load(article.urlToImage)
            .into(image)
        image.setOnClickListener {
           clickListener()
        }
    }
}