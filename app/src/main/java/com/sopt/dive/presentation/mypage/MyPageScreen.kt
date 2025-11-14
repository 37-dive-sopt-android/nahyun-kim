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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.dive.DiveApplication
import com.sopt.dive.R
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.core.util.noRippleClickable
import com.sopt.dive.domain.model.auth.UserInfoModel
import com.sopt.dive.presentation.mypage.component.ProfileSpringCard

@Composable
fun MyPageRoute(
    paddingValues: PaddingValues,
    navigateToSignIn: () -> Unit
) {
    val app = LocalContext.current.applicationContext as DiveApplication
    val repository = remember { app.appContainer.userRepository }

    var user by remember { mutableStateOf<UserInfoModel?>(null) }

    LaunchedEffect(repository) {
        repository.getMyProfile()
            .onSuccess { user = it }
            .onFailure {
                navigateToSignIn()
            }
    }

    user?.let { model ->
        MypageScreen(
            modifier = Modifier.padding(paddingValues),
            userInfoModel = model,
            onLogoutClick = {
                //TODO: 로그아웃
                navigateToSignIn()
            }
        )
    }
}

@Composable
private fun MypageScreen(
    userInfoModel: UserInfoModel,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        ProfileSpringCard(
            frontImageRes = R.drawable.img_profile_dummy,
            backText = "안녕하세요?\n완두콩입니다\n콩콩콩"
        )

        Spacer(Modifier.height(20.dp))

        UserInfoRow(
            titleLabelRes = R.string.id_label,
            infoText = userInfoModel.id,
            modifier = Modifier.fillMaxWidth()
        )

        UserInfoRow(
            titleLabelRes = R.string.name_label,
            infoText = userInfoModel.name,
            modifier = Modifier.fillMaxWidth()
        )

        UserInfoRow(
            titleLabelRes = R.string.email_label,
            infoText = userInfoModel.email,
            modifier = Modifier.fillMaxWidth()
        )

        UserInfoRow(
            titleLabelRes = R.string.age_label,
            infoText = "${userInfoModel.age}",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.weight(1f))

        LogoutButton(
            onLogoutClick = onLogoutClick,
            modifier = Modifier.align(Alignment.CenterHorizontally)
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

@Composable
private fun LogoutButton(
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(R.string.logout),
        fontSize = 16.sp,
        style = TextStyle(fontWeight = FontWeight.Medium),
        textDecoration = TextDecoration.Underline,
        color = Color.DarkGray,
        modifier = modifier
            .padding(5.dp)
            .noRippleClickable(onClick = onLogoutClick)
            .padding(top = 5.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    DiveTheme {
        MypageScreen(
            onLogoutClick = {},
            userInfoModel = UserInfoModel(
                id = "nahyun",
                name = "작나",
                email = "user@gmail.com",
                age = 23
            )
        )
    }
}