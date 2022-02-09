package com.thussey.photobomb.ui.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thussey.photobomb.data.Result
import com.thussey.photobomb.data.model.util.UiState
import com.thussey.photobomb.data.repository.photo.PhotoRepository
import com.thussey.photobomb.data.repository.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val photoRepository: PhotoRepository,
    private val userRepository: UserRepository,
    private val savedStateHandle : SavedStateHandle
) : ViewModel() {
    val tag = HomeViewModel::class.java.simpleName

    private val _homeState = MutableStateFlow(HomeState())
    val homeState = _homeState.asStateFlow()
    private val simpleDateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.US)

    init {
    }

    /*fun getUsers() {
        viewModelScope.launch {
            //val result =  userRepository.getUserById("66496f55-ecc7-47e2-92fa-8b76d7c22503")
            val result = photoRepository.getPhotoSessions("66496f55-ecc7-47e2-92fa-8b76d7c22503")
            if (result is Result.Success) {
                val photoSessions = result.data
            }
        }
    }*/

    fun getPhotoSessions() {
        viewModelScope.launch {
            val result = photoRepository.getPhotoSessions("66496f55-ecc7-47e2-92fa-8b76d7c22503")
            if (result is Result.Success) {
                _homeState.value = _homeState.value.copy(photoSessions = result.data)
                buildPhotoSessionAdapterItems()
            }
        }
    }

    fun buildPhotoSessionAdapterItems() {
        val photoSessionItems = mutableListOf<PhotoSessionItem>()
        viewModelScope.launch {
            _homeState.value.photoSessions.forEach { photoSession ->
                val photoResult = photoRepository.getPhotoById(photoSession.thumbnailPhotoId)
                if (photoResult is Result.Success) {
                    val data = photoResult.data
                    photoSessionItems.add(PhotoSessionItem(photoSession.photoSessionId,
                        data.url,
                        photoSession.title,
                        simpleDateFormat.format(photoSession.date)))
                } else {
                    val error = photoResult
                }
            }
            _homeState.value = _homeState.value.copy(uiState = UiState.LOADED,
                photoSessionAdapterItems = photoSessionItems)
        }
    }
}