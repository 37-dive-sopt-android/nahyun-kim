package com.sopt.dive.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.dive.R
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.domain.model.friend.FriendProfile
import com.sopt.dive.presentation.home.HomeViewModel.Companion.dummyFriendProfiles
import com.sopt.dive.presentation.home.component.FriendCard
import com.sopt.dive.presentation.home.component.MyProfileCard
import kotlinx.collections.immutable.ImmutableList

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
    viewModel: HomeViewModel = viewModel()
) {
    val context = LocalContext.current

    viewModel.setMyProfile(context)
    val userInfo = viewModel.myProfile.collectAsStateWithLifecycle().value

    HomeScreen(
        myNickname = userInfo.nickname,
        friendList = viewModel.friendProfile.collectAsStateWithLifecycle().value,
        modifier = Modifier.padding(paddingValues)
    )
}

@Composable
fun HomeScreen(
    myNickname: String,
    friendList: ImmutableList<FriendProfile>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxSize()
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        item {
            Text(
                text = "Home",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
            )
        }

        item {
            MyProfileCard(
                profileImage = R.drawable.img_profile_dummy,
                nickname = myNickname,
                modifier = Modifier.fillMaxWidth()
            )
        }

        itemsIndexed(
            items = friendList,
            key = { _, friend -> friend.nickname }
        ) { index, friend ->
            FriendCard(
                order = index + 1,
                friendProfile = friend,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    DiveTheme {
        HomeScreen(
            myNickname = "잠만보",
            friendList = dummyFriendProfiles
        )
    }
}