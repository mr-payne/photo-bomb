package com.thussey.photobomb.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.thussey.photobomb.data.model.user.User
import com.thussey.photobomb.data.repository.photo.PhotoRepository
import com.thussey.photobomb.data.repository.user.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
        val photoSessions = photoRepository.getPhotoSessions()
        _homeState.value = _homeState.value.copy(photoSessions = photoSessions)
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.getUsers().enqueue(object : Callback<List<User>> {
                override fun onFailure(call: Call<List<User>>?, t: Throwable?) {
                    Log.e(tag, "call failed", t)
                }

                override fun onResponse(call: Call<List<User>>?, response: Response<List<User>>?) {
                    response.toString()
                }

            })
        }
    }

}