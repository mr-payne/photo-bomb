package com.thussey.photobomb.ui.dashboard

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

class DashboardAdapter(private val photos : List<Photo>) :
    RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    inner class ViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        val photo : ImageView = view.findViewById(R.id.photo)
        val photoName : TextView = view.findViewById(R.id.photoName)
        val deleteBtn : ImageView = view.findViewById(R.id.delete)
        val shopBtn : ImageView = view.findViewById(R.id.shop)
        val commentBtn : ImageView = view.findViewById(R.id.comment)
        init {
            photo.setOnClickListener {
                val action = DashboardFragmentDirections.actionNavigationDashboardToFullscreenImg(photos[adapterPosition].url)
                view.findNavController().navigate(action)
            }
        }
    }

    override fun getItemCount() = photos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photos[position]
        holder.photoName.text = photo.name

        Picasso.get()
            .load(photo.url)
            .placeholder(R.drawable.ic_placeholder_photo_24)
            .error(R.drawable.ic_image_not_supported_black_24dp)
            .into(holder.photo);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.favorite_item, parent, false)
        return ViewHolder(view)
    }

}