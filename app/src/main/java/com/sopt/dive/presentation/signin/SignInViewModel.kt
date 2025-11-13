package com.sopt.dive.presentation.signin

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.toRoute
import com.sopt.dive.DiveApplication
import com.sopt.dive.data.local.prefs.UserPreferences
import com.sopt.dive.domain.model.auth.LoginError
import com.sopt.dive.domain.model.auth.LoginResult
import com.sopt.dive.presentation.signin.navigation.SignIn
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SignInViewModel(
    savedStateHandle: SavedStateHandle,
    private val userPrefs: UserPreferences
) : ViewModel() {
    val registerUserInfo = savedStateHandle.toRoute<SignIn>()

    private val _id = MutableStateFlow("")
    val id: StateFlow<String> = _id

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    fun onIdChange(id: String) {
        _id.update { id }
    }

    fun onPasswordChange(password: String) {
        _password.update { password }
    }

    fun getLoginResult(): LoginResult {
        val idValue = id.value
        val pwValue = password.value

        return when {
            idValue.isBlank() || pwValue.isBlank() -> { // 로그인 정보 없음
                LoginResult.Failure(LoginError.LOGIN_EMPTY)
            }

            registerUserInfo.id.isBlank() || registerUserInfo.password.isBlank() -> { // 회원가입 전
                LoginResult.Failure(LoginError.NOT_REGISTER)
            }

            idValue == registerUserInfo.id && pwValue == registerUserInfo.password -> { // 로그인 성공
                LoginResult.Success
            }

            else -> { // 회원가입 정보와 불일치
                LoginResult.Failure(LoginError.INVALID_INFO)
            }
        }
    }

    fun saveUserInfo() {
        userPrefs.saveUserInfo(
            id = id.value,
            password = password.value,
            nickname = registerUserInfo.nickname,
            mbti = registerUserInfo.mbti
        )
    }

    companion object {
        fun provideFactory(app: DiveApplication): ViewModelProvider.Factory =
            viewModelFactory {
                initializer {
                    val saved = createSavedStateHandle()
                    val prefs = app.appContainer.userPreferences
                    SignInViewModel(saved, prefs)
                }
            }
    }
}