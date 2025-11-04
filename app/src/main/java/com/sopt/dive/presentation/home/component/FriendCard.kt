package com.sopt.dive.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.domain.model.friend.FriendProfile
import com.sopt.dive.domain.model.friend.ProfileTag

@Composable
fun FriendCard(
    order: Int,
    friendProfile: FriendProfile,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.padding(vertical = 12.dp)
    ) {
        Text(
            text = "$order",
            modifier = Modifier.sizeIn(minWidth = 30.dp)
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(friendProfile.profileColor)
        )
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = friendProfile.nickname,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
            if (!friendProfile.bio.isNullOrBlank()) {
                Text(
                    text = friendProfile.bio,
                    color = Color.DarkGray,
                    fontSize = 12.sp
                )
            }
        }
        Spacer(Modifier.weight(1f))
        ProfileTag(profileTag = friendProfile.profileTag)
    }
}

@Composable
fun ProfileTag(
    profileTag: ProfileTag,
    modifier: Modifier = Modifier
) {
    val tagText = when (profileTag) {
        is ProfileTag.Birthday -> "선물하기"
        is ProfileTag.Music -> "${profileTag.musicName} - ${profileTag.musicAuthor}"
        else -> ""
    }

    if (tagText.isNotBlank()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = modifier
                .clip(CircleShape)
                .border(1.dp, profileTag.tagStyle.borderColor, CircleShape)
                .padding(vertical = 2.dp, horizontal = 6.dp)
        ) {
            Text(
                text = tagText,
                color = Color.Black,
                fontSize = 10.sp
            )
            Text( // TODO: 아이콘으로 변경
                text = profileTag.tagStyle.icon,
                fontSize = 10.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FriendCardPreview() {
    DiveTheme {
        FriendCard(
            order = 1,
            friendProfile = FriendProfile(
                profileColor = Color.Blue,
                nickname = "김나현"
            )
        )
    }

}