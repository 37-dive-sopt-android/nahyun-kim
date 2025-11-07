package com.sopt.dive.presentation.mypage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.dive.R
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.data.local.UserPreferences
import com.sopt.dive.domain.model.auth.UserInfo
import com.sopt.dive.presentation.mypage.component.ProfileCard

@Composable
fun MyPageRoute(
    paddingValues: PaddingValues
) {
    val context = LocalContext.current
    val userPreferences = remember { UserPreferences(context) }

    MypageScreen(
        userInfo = userPreferences.getUserInfo(),
        modifier = Modifier.padding(paddingValues)
    )
}

@Composable
fun MypageScreen(
    userInfo: UserInfo,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        ProfileCard()

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = stringResource(R.string.id_label),
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
            )

            Text(
                text = userInfo.id,
                fontSize = 24.sp
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = stringResource(R.string.password_label),
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
            )

            Text(
                text = userInfo.password,
                fontSize = 24.sp,
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = stringResource(R.string.nickname_label),
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
            )

            Text(
                text = userInfo.nickname,
                fontSize = 24.sp,
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = stringResource(R.string.mbti_label),
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
            )

            Text(
                text = userInfo.mbti,
                fontSize = 24.sp,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    DiveTheme {
        MypageScreen(
            userInfo = UserInfo(
                id = "nahyun",
                password = "password",
                nickname = "작나",
                mbti = "ESTP"
            ),
        )
    }
}