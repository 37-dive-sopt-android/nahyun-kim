package com.sopt.dive.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.sopt.dive.domain.model.friend.Friend

@Composable
fun FriendCard(
    order: Int,
    friend: Friend,
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
                .background(friend.profileColor)
        )
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = friend.nickname,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )
            if (!friend.bio.isNullOrBlank()) {
                Text(
                    text = friend.bio,
                    color = Color.DarkGray,
                    fontSize = 12.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FriendCardPreview() {
    DiveTheme {
        FriendCard(
            order = 1,
            friend = Friend(
                profileColor = Color.Blue,
                nickname = "김나현"
            )
        )
    }

}