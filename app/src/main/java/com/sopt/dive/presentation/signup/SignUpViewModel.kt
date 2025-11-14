package com.sopt.dive.presentation.signup

import androidx.lifecycle.ViewModel
import com.sopt.dive.core.util.AuthValidator.validateId
import com.sopt.dive.core.util.AuthValidator.validateMbti
import com.sopt.dive.core.util.AuthValidator.validateNickname
import com.sopt.dive.core.util.AuthValidator.validatePassword
import com.sopt.dive.domain.model.auth.UserInfoModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SignUpViewModel : ViewModel() {
    private val _userInfoModel = MutableStateFlow<UserInfoModel>(UserInfoModel.Empty)
    val userInfoModel: StateFlow<UserInfoModel> = _userInfoModel

    fun onIdChange(id: String) {
        _userInfoModel.update { it.copy(id = id) }
    }

    fun onPasswordChange(password: String) {
        _userInfoModel.update { it.copy(password = password) }
    }

    fun onNicknameChange(nickname: String) {
        _userInfoModel.update { it.copy(nickname = nickname) }
    }

    fun onMbtiChange(mbti: String) {
        _userInfoModel.update { it.copy(mbti = mbti) }
    }

    fun isValid(): Boolean {
        return with(_userInfoModel.value) {
            validateId(id) && validatePassword(password) && validateNickname(nickname) && validateMbti(mbti)
        }
    }
}