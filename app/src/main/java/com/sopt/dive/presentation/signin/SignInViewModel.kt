package com.sopt.dive.presentation.signin

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.sopt.dive.DiveApplication
import com.sopt.dive.domain.repository.AuthRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(SignInUiState())
    val uiState: StateFlow<SignInUiState> = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<LoginSideEffect>()
    val sideEffect: SharedFlow<LoginSideEffect> = _sideEffect.asSharedFlow()

    fun onIdChange(id: String) {
        _uiState.update { it.copy(id = id) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun tryLogin() {
        viewModelScope.launch {
            authRepository.login(
                userName = uiState.value.id,
                password = uiState.value.password
            ).onSuccess {
                _sideEffect.emit(LoginSideEffect.NavigateToHome)
            }.onFailure {
                _sideEffect.emit(LoginSideEffect.ShowErrorToast(it.message ?: "로그인 실패"))
            }
        }
    }

    companion object {
        fun provideFactory(app: DiveApplication): ViewModelProvider.Factory =
            viewModelFactory {
                initializer {
                    val repo = app.appContainer.authRepository
                    SignInViewModel(repo)
                }
            }
    }
}

sealed interface LoginSideEffect {
    data object NavigateToHome : LoginSideEffect
    data class ShowErrorToast(val message: String) : LoginSideEffect
}
