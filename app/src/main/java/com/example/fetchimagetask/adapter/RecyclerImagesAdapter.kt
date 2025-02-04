package com.example.fetchimagetask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.fetchimagetask.R

class RecyclerImagesAdapter(val context: Context, val imagesList: MutableList<String>) : RecyclerView.Adapter<RecyclerImagesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerImagesAdapter.ViewHolder {
       val v: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerImagesAdapter.ViewHolder, position: Int) {
        Glide
            .with(context)
            .load(imagesList[position])
            .thumbnail(0.1f)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return imagesList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image = itemView.findViewById<AppCompatImageView>(R.id.image)
    }

    fun updateRecycler(list: MutableList<String>){
        val oldSize = imagesList.size
        imagesList.addAll(list)
        val newSize = imagesList.size
        notifyItemRangeChanged(oldSize, newSize)
    }
}