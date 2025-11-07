package com.sopt.dive.presentation.home

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.sopt.dive.data.local.UserPreferences
import com.sopt.dive.domain.model.auth.UserInfo
import com.sopt.dive.domain.model.friend.FriendProfile
import com.sopt.dive.domain.model.friend.ProfileTag
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {
    private val _myProfileInfo = MutableStateFlow(UserInfo.Fake)
    val myProfile: StateFlow<UserInfo> = _myProfileInfo.asStateFlow()

    private val _friendProfiles = MutableStateFlow(dummyFriendProfile)
    val friendProfile: StateFlow<ImmutableList<FriendProfile>> = _friendProfiles

    fun setMyProfile(context: Context) { // TODO: 수정 필요
        _myProfileInfo.value = UserPreferences(context).getUserInfo()
    }

    companion object {
        val dummyFriendProfile = persistentListOf(
            FriendProfile(
                profileColor = Color.Blue,
                nickname = "완두콩 3조",
                bio = "코드리뷰 파이팅!!"
            ),
            FriendProfile(
                profileColor = Color.Yellow,
                nickname = "갓동민",
                bio = "👑",
                profileTag = ProfileTag.Music(
                    musicName = "Kyo181",
                    musicAuthor = "실리카겔"
                )
            ),
            FriendProfile(
                profileColor = Color.Magenta,
                nickname = "임차민",
                profileTag = ProfileTag.Birthday
            ),
            FriendProfile(
                profileColor = Color.Red,
                nickname = "성규현"
            ),
            FriendProfile(
                profileColor = Color.Green,
                nickname = "완두콩",
                bio = "떼굴뗴굴",
                profileTag = ProfileTag.Music(
                    musicName = "Thunder",
                    musicAuthor = "Imagine Dragons"
                )
            ),
            FriendProfile(
                profileColor = Color.LightGray,
                nickname = "최고"
            ),
            FriendProfile(
                profileColor = Color.DarkGray,
                nickname = "디솝"
            ),
            FriendProfile(
                profileColor = Color.Yellow,
                nickname = "학교 가기 싫어요",
                bio = "휴학 솝트가.. 그렇게 좋다죠??ㅠㅠ",
                profileTag = ProfileTag.Birthday
            ),
            FriendProfile(
                profileColor = Color.Yellow,
                nickname = "살려주세요"
            ),
            FriendProfile(
                profileColor = Color.Green,
                nickname = "잠을자고싶어요",
                bio = "Zzzzzzzzz"
            ),
            FriendProfile(
                profileColor = Color.Magenta,
                nickname = "하루만 집에서 푹 쉴래요"
            )
        )
    }
}
