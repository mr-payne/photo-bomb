package com.thussey.photobomb.ui.photosession

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thussey.photobomb.data.Result
import com.thussey.photobomb.data.model.photo.Photo
import com.thussey.photobomb.data.model.util.UiState
import com.thussey.photobomb.data.repository.photo.PhotoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class PhotoSessionViewModel @Inject constructor(
    private val photoRepository: PhotoRepository,
    private val savedStateHandle: SavedStateHandle) : ViewModel() {

    val tag = PhotoSessionViewModel::class.java.simpleName

    private val _photoSessionState = MutableStateFlow(PhotoSessionState())
    val photoSessionState = _photoSessionState.asStateFlow()

    init {

    }

    fun getPhotoSessionPhotos(photoSessionId : UUID) {
        viewModelScope.launch {
            photoRepository.getPhotos(photoSessionId).collectLatest { photoResult ->
                if (photoResult is Result.Success) {
                    _photoSessionState.value =
                        _photoSessionState.value.copy(photos = photoResult.data, uiState = UiState.LOADED)
                } else {
                    //todo: handle error
                }
            }
        }
    }

    fun updatePhoto(photo : Photo) {
        viewModelScope.launch {
            photoRepository.updatePhoto(photo).collectLatest { photoResult ->
                if (photoResult is Result.Success) {
                    Log.d(tag, "$tag : photoupdate success")
                } else {
                    //todo: handle error
                }
            }
        }
    }

}