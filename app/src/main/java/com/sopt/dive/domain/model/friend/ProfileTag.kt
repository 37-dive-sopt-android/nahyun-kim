package com.sopt.dive.domain.model.friend

sealed class ProfileTag {
    data class Music(val musicName: String, val musicAuthor: String) : ProfileTag()
    data object Birthday : ProfileTag()
    data object None : ProfileTag()
}