package com.sopt.dive.domain.model.friend

import androidx.compose.ui.graphics.Color

enum class TagStyle(
    val borderColor: Color,
    val icon: String
) {
    DEFAULT(
        borderColor = Color.Transparent,
        icon = ""
    ),
    MUSIC(
        borderColor = Color.Green,
        icon = "▶️"
    ),
    BIRTHDAY(
        borderColor = Color.Red,
        icon = "🎁"
    )
}

sealed class ProfileTag(
    val tagStyle: TagStyle
) {
    data object None: ProfileTag(TagStyle.DEFAULT)

    data class Music(
        val musicName: String,
        val musicAuthor: String
    ) : ProfileTag(TagStyle.MUSIC)

    data object Birthday : ProfileTag(TagStyle.BIRTHDAY)
}