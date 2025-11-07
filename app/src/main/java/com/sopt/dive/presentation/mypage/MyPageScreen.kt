package com.sopt.dive.presentation.mypage

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.sopt.dive.presentation.mypage.component.ProfileSpringCard

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
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        ProfileSpringCard()

        Spacer(Modifier.height(20.dp))

        UserInfoRow(
            titleLabelRes = R.string.id_label,
            infoText = userInfo.id,
            modifier = Modifier.fillMaxWidth()
        )

        UserInfoRow(
            titleLabelRes = R.string.password_label,
            infoText = userInfo.password,
            modifier = Modifier.fillMaxWidth()
        )

        UserInfoRow(
            titleLabelRes = R.string.nickname_label,
            infoText = userInfo.nickname,
            modifier = Modifier.fillMaxWidth()
        )

        UserInfoRow(
            titleLabelRes = R.string.mbti_label,
            infoText = userInfo.mbti,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun UserInfoRow(
    @StringRes titleLabelRes: Int,
    infoText: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(titleLabelRes),
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
        )

        Text(
            text = infoText,
            fontSize = 24.sp,
        )
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