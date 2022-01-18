package com.example.newsappnovosad.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappnovosad.R
import com.example.newsappnovosad.model.WebSite
import com.example.newsappnovosad.service.ItemClickListener

class ListSourceAdapter(private val context: Context, private val webSite: WebSite) :
    RecyclerView.Adapter<ListSourceViewHolder>() {
    @SuppressLint("ResourceType")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListSourceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.id.id_News, parent, false)
        return ListSourceViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return webSite.articles!!.size
    }

    override fun onBindViewHolder(holder: ListSourceViewHolder, position: Int) {
        holder.source_title.tooltipText = webSite.articles!![position].source!!.name

        holder.setItemClickListener(object : ItemClickListener
        {
            override fun onCLick(view: View, position: Int) {
                Toast.makeText(context, "pampam", Toast.LENGTH_SHORT).show()
            }
        })
    }
}