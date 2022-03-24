package com.thussey.photobomb.ui.photosession

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.thussey.photobomb.R
import com.thussey.photobomb.data.model.photo.Photo

class PhotoRVAdapter(private val photos : List<Photo>, val updatePhoto : (photo : Photo) -> Unit)
    : RecyclerView.Adapter<PhotoRVAdapter.ViewHolder>() {
    val tag = this::class.java.simpleName

    inner class ViewHolder(val view : View) : RecyclerView.ViewHolder(view) {

        val photoName : TextView = view.findViewById(R.id.photoName)
        val favStar : ImageView = view.findViewById(R.id.fav_star)
        val photo : ImageView = view.findViewById(R.id.photo)

        init {
            favStar.setOnClickListener { starImg ->
                var selectedPhoto = photos[adapterPosition]
                val isSelected = !starImg.isSelected
                starImg.isSelected = isSelected
                selectedPhoto = selectedPhoto.copy(isFavorite = isSelected)
                updatePhoto(selectedPhoto)
                applyStarStyles(starImg as ImageView, isSelected)
            }

            photo.setOnClickListener {
                val action = PhotoSessionFragmentDirections.actionPhotoSessionFragmentToFullscreenImgFragment(photos[adapterPosition].url)
                view.findNavController().navigate(action)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
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
    }
}