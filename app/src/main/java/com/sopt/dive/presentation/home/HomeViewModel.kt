package com.sopt.dive.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.sopt.dive.DiveApplication
import com.sopt.dive.core.util.UiState
import com.sopt.dive.domain.model.friend.FriendProfile
import com.sopt.dive.domain.repository.UserRepository
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import okhttp3.internal.toImmutableList
import kotlin.onSuccess

class HomeViewModel(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<HomeUiState>>(UiState.Loading)
    val uiState: StateFlow<UiState<HomeUiState>> = _uiState.asStateFlow()

    init {
//        loadMyProfileInfo()
        loadFriendProfileInfo()
    }

    fun loadMyProfileInfo() {
        viewModelScope.launch { // coroutine
            userRepository.getMyProfile()
                .onSuccess { result ->
                    _uiState.update {
                        UiState.Success(
                            HomeUiState(
                                myProfile = result
                            )
                        )
                    }
                }
                .onFailure {
                    _uiState.update { UiState.Failure }
                }
        }
    }

    fun loadFriendProfileInfo() {
        viewModelScope.launch {
            userRepository.getFriends()
                .onSuccess { result ->
                    Log.d("Home", "loadFriendProfileInfo result: $result")
                    _uiState.update {
                        UiState.Success(
                            HomeUiState(
                                friendList = result.toPersistentList()
                            )
                        )
                    }
                }
                .onFailure { it ->
                    Log.d("Home", "loadFriendProfileInfo onFailure $it")
                    _uiState.update { UiState.Failure }
                }
        }
    }

    companion object {
        fun provideFactory(app: DiveApplication): ViewModelProvider.Factory =
            viewModelFactory {
                initializer {
                    val repo = app.appContainer.userRepository
                    HomeViewModel(repo)
                }
            }
    }
}
