package com.thussey.photobomb.ui.home

import com.thussey.photobomb.data.model.photosession.PhotoSession
import com.thussey.photobomb.data.model.util.UiState

data class HomeState(val photoSessions : List<PhotoSession> = listOf(), val uiState : UiState = UiState.LOADING)
