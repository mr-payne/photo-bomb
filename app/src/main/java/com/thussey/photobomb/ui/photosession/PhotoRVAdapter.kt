package com.thussey.photobomb.ui.photosession

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.thussey.photobomb.R
import com.thussey.photobomb.data.model.photo.Photo

class PhotoRVAdapter(private val photos : List<Photo>, val viewModel : PhotoSessionViewModel)
    : RecyclerView.Adapter<PhotoRVAdapter.ViewHolder>() {

    val tag = this::class.java.simpleName

    inner class ViewHolder(val view : View) : RecyclerView.ViewHolder(view) {

        val photoName : TextView = view.findViewById(R.id.photoName)
        val favStar : ImageView = view.findViewById(R.id.fav_star)
        val photo : ImageView = view.findViewById(R.id.photo)

        init {
            favStar.setOnClickListener {
                it.isSelected = !it.isSelected
                var selectedPhoto = photos[adapterPosition]
                selectedPhoto = selectedPhoto.copy(isFavorite = it.isSelected)
                viewModel.updatePhoto(selectedPhoto)
                applyStarStyles(it as ImageView, it.isSelected)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoRVAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoRVAdapter.ViewHolder, position: Int) {
        val photo = photos[position]
        holder.photoName.text = photo.name
        holder.favStar.isSelected = photo.isFavorite
        applyStarStyles(holder.favStar, photo.isFavorite)

        Picasso.get()
            .load(photo.url)
            .placeholder(R.drawable.ic_placeholder_photo_24)
            .error(R.drawable.ic_image_not_supported_black_24dp)
            .into(holder.photo);
    }

    override fun getItemCount() = photos.size

    private fun applyStarStyles(imageView : ImageView, isSelected : Boolean) {
        if (isSelected) {
            imageView.setImageResource(R.drawable.ic_star_black_24dp)
        } else {
            imageView.setImageResource(R.drawable.ic_star_outline_black_24dp)
        }
        imageView.setColorFilter(ContextCompat.getColor(imageView.context, R.color.gold), android.graphics.PorterDuff.Mode.SRC_IN);
    }
}