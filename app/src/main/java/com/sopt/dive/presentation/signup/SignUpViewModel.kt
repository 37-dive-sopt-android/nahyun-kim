package com.sopt.dive.presentation.signup

import android.util.Log
import androidx.core.text.isDigitsOnly
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

class SignUpViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<SignUpSideEffect>()
    val sideEffect: SharedFlow<SignUpSideEffect> = _sideEffect.asSharedFlow()

    fun onIdChange(id: String) {
        _uiState.update { it.copy(id = id) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password) }
    }

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email) }
    }

    fun onNameChange(name: String) {
        _uiState.update { it.copy(name = name) }
    }

    fun onAgeChange(age: String) {
        if (!age.isDigitsOnly()) return
        _uiState.update { it.copy(age = age) }
    }

    fun trySignUp() {
        viewModelScope.launch {
            authRepository.signUp(
                userName = _uiState.value.id,
                password = _uiState.value.password,
                name = _uiState.value.name,
                email = _uiState.value.email,
                age = _uiState.value.age.toInt()
            ).onSuccess {
                _sideEffect.emit(SignUpSideEffect.NavigateToSignIn)
            }.onFailure {
                Log.d("SignUp", "onFailure: $it")
                _sideEffect.emit(SignUpSideEffect.ShowToast("회원가입 실패"))
            }
        }
    }

    companion object {
        fun provideFactory(app: DiveApplication): ViewModelProvider.Factory =
            viewModelFactory {
                initializer {
                    val repo = app.appContainer.authRepository
                    SignUpViewModel(repo)
                }
            }
    }
}

sealed interface SignUpSideEffect {
    data object NavigateToSignIn : SignUpSideEffect
    data class ShowToast(val message: String) : SignUpSideEffect
}