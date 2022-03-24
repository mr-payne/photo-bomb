package com.thussey.photobomb.ui.fullscreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import com.thussey.photobomb.R
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val PHOTO_URL = "PHOTO_URL"

/**
 * A simple [Fragment] subclass.
 * Use the [FullscreenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class FullscreenFragment : Fragment() {
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            url = it.getString(PHOTO_URL)
            Log.d(tag, "url: $url")
        }
        Log.d(tag, "url: $url")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(tag, "url: $url")

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fullscreen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageview = view.findViewById<ImageView>(R.id.fullscreen_img)

        Picasso.get()
            .load(url)
            .placeholder(R.drawable.ic_placeholder_photo_24)
            .error(R.drawable.ic_image_not_supported_black_24dp)
            .into(imageview);
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FullscreenFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(url: String) =
            FullscreenFragment().apply {
                arguments = Bundle().apply {
                    putString(PHOTO_URL, url)
                }
            }
    }
}