package com.example.tugaslistnewjumat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugaslistnewjumat.R
import com.example.tugaslistnewjumat.model.GetAllNewsItem
import kotlinx.android.synthetic.main.item_adapter.view.*

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private var datanews : List<GetAllNewsItem>? = null

    fun setDataNews(news : List<GetAllNewsItem>){
        this.datanews = news
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_adapter, parent, false)
        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tvTitle.text = datanews!![position].title
        holder.itemView.tvAuthor.text = datanews!![position].author
        holder.itemView.tvDate.text = datanews!![position].createdAt
        Glide.with(holder.itemView.context).load(datanews!![position].image).into(holder.itemView.imgNews)
//        holder.itemView.cardFilm.setOnClickListener {
//            onClick(datanews!![position])
//        }
    }

    override fun getItemCount(): Int {
        if (datanews == null){
            return 0
        }
        else{
            return datanews?.size!!
        }
    }
}