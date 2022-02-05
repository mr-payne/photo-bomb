package com.thussey.photobomb.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.thussey.photobomb.R

class PhotoSessionRVAdapter(private val photoSessions : List<PhotoSessionItem>)
    : RecyclerView.Adapter<PhotoSessionRVAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val photoSessionTitle : TextView = view.findViewById(R.id.photoSessionTitle)
        val photoSessionDate : TextView = view.findViewById(R.id.photoSessionDate)
        val sessionThumbnail : ImageView = view.findViewById(R.id.sessionThumbnail)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_session_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photoSession = photoSessions[position]
        holder.photoSessionTitle.text = photoSession.title
        holder.photoSessionDate.text = photoSession.date
        Picasso.get()
            .load(photoSession.thumbnailUrl)
            .placeholder(R.drawable.ic_placeholder_photo_24)
            .error(R.drawable.ic_image_not_supported_black_24dp)
            .into(holder.sessionThumbnail);
    }

    override fun getItemCount() = photoSessions.size
}