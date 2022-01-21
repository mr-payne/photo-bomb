package com.thussey.photobomb.ui.home

import androidx.lifecycle.*
import com.thussey.photobomb.data.repository.photo.PhotoRepository
import com.thussey.photobomb.data.repository.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
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


    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = savedStateHandle.getLiveData("text", "default Text")

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            val users = userRepository.getUsers()
        }
    }

}