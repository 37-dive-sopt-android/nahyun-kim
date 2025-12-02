package com.sopt.dive.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sopt.dive.DiveApplication
import com.sopt.dive.R
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.core.util.UiState
import com.sopt.dive.domain.model.friend.FriendProfile
import com.sopt.dive.presentation.home.component.FriendProfileCard
import com.sopt.dive.presentation.home.component.MyProfileCard
import kotlinx.collections.immutable.ImmutableList

@Composable
fun HomeRoute(
    paddingValues: PaddingValues,
) {
    val context = LocalContext.current
    val app = context.applicationContext as DiveApplication

    val viewModel: HomeViewModel = viewModel(
        factory = HomeViewModel.provideFactory(app)
    )

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val state = uiState) {
        is UiState.Success -> HomeScreen(
            myNickname = state.data.myProfile.id,
            friendList = state.data.friendList,
            modifier = Modifier.padding(paddingValues)
        )
        is UiState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        else -> {}
    }
}

@Composable
private fun HomeScreen(
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
            key = { index, friend -> "${index}-${friend.name}" }
        ) { index, friend ->
            FriendProfileCard(
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
//        HomeScreen(
//            myNickname = "잠만보",
//            friendList = dummyFriendProfiles
//        )
    }
}