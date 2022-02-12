package com.thussey.photobomb.ui.photosession

import com.thussey.photobomb.data.model.photo.Photo
import com.thussey.photobomb.data.model.util.UiState
import java.util.*

data class PhotoSessionState(
    val photoSessionId : UUID = UUID.randomUUID(),
    val uiState: UiState = UiState.LOADING,
    val photos : List<Photo> = emptyList())
