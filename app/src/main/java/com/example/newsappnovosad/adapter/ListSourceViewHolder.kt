package com.example.newsappnovosad.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.newsappnovosad.R
import com.example.newsappnovosad.service.ItemClickListener

class ListSourceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),View.OnClickListener {
    var source_title = itemView.findViewById<RecyclerView>(R.id.id_TVNewsHeading) // внутри метода bind
    private lateinit var itemClickListener:ItemClickListener

    fun setItemClickListener(itemClickListener: ItemClickListener){
        this.itemClickListener = itemClickListener
    }

    override fun onClick(p0: View?) {
        itemClickListener.onCLick(p0!!,adapterPosition)
    }



}