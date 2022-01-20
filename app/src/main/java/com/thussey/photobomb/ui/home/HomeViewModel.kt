package com.thussey.photobomb.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val savedStateHandle : SavedStateHandle
) : ViewModel() {

    private val _homeState = MutableStateFlow(HomeState())
    val homeState = _homeState.asStateFlow()


    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = savedStateHandle.getLiveData("text", "default Text")
}