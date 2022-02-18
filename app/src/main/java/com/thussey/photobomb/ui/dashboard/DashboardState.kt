package com.thussey.photobomb.ui.dashboard

import com.thussey.photobomb.data.model.photo.Photo
import com.thussey.photobomb.data.model.util.UiState

data class DashboardState(val uiState : UiState = UiState.LOADING,
                          val favorites : List<Photo> = emptyList())