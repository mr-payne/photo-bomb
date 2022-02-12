package com.thussey.photobomb.ui.photosession

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.thussey.photobomb.R
import com.thussey.photobomb.data.model.photo.Photo

class PhotoRVAdapter(private val photos : List<Photo>)
    : RecyclerView.Adapter<PhotoRVAdapter.ViewHolder>() {

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val photoName : TextView = view.findViewById(R.id.photoName)
        val favStar : ImageView = view.findViewById(R.id.fav_star)
        val photo : ImageView = view.findViewById(R.id.photo)

        //todo: setOnClickListener for favStar
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoRVAdapter.ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
        return PhotoRVAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoRVAdapter.ViewHolder, position: Int) {
        val photo = photos[position]
        holder.photoName.text = photo.name
        //todo: handle favorite

        Picasso.get()
            .load(photo.url)
            .placeholder(R.drawable.ic_placeholder_photo_24)
            .error(R.drawable.ic_image_not_supported_black_24dp)
            .into(holder.photo);
    }

    override fun getItemCount() = photos.size
}