package com.thussey.photobomb.ui.home

import com.thussey.photobomb.data.model.photosession.PhotoSession

data class HomeState(val photoSessions : MutableList<PhotoSession> = mutableListOf())
