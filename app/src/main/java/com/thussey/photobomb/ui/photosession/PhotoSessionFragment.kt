package com.thussey.photobomb.ui.photosession

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.thussey.photobomb.data.model.util.UiState
import com.thussey.photobomb.databinding.FragmentPhotoSessionBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val PHOTO_SESSION_ID = "photoSessionId"

/**
 * Use the [PhotoSessionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class PhotoSessionFragment : Fragment() {

    private val photoSessionViewModel: PhotoSessionViewModel by viewModels()
    private var _binding: FragmentPhotoSessionBinding? = null

    // TODO: Rename and change types of parameters
    private lateinit var photoSessionId: UUID

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            photoSessionId = UUID.fromString(it.getString(PHOTO_SESSION_ID))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotoSessionBinding.inflate(inflater, container, false)
        val root : View = binding.root

        viewLifecycleOwner.lifecycleScope.launch {
            photoSessionViewModel.photoSessionState.collectLatest { photoSessionState ->
                if (photoSessionState.uiState == UiState.LOADED) {
                    binding.photos.adapter = PhotoRVAdapter(photoSessionState.photos)
                }
            }
        }

        photoSessionViewModel.getPhotoSessionPhotos(photoSessionId)

        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PhotoSessionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            PhotoSessionFragment().apply {
                arguments = Bundle().apply {
                    putString(PHOTO_SESSION_ID, param1)
                }
            }
    }
}