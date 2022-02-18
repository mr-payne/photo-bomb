package com.thussey.photobomb.ui.dashboard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thussey.photobomb.data.Result
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
class DashboardViewModel @Inject constructor(
    private val photoRepository: PhotoRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _dashboardSate = MutableStateFlow(DashboardState())
    val dashboardState = _dashboardSate.asStateFlow()

    fun getFavorites() {
        viewModelScope.launch {
            photoRepository.getUserPhotos(
                UUID.fromString("66496f55-ecc7-47e2-92fa-8b76d7c22503")).collectLatest { result ->
                if (result is Result.Success) {
                    val favorites = result.data.filter { it.isFavorite }
                    _dashboardSate.value = _dashboardSate.value.copy(favorites = favorites, uiState = UiState.LOADED)
                } else {
                    //todo: handle error case
                }
            }
        }
    }
}