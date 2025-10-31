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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.domain.model.friend.dummyFriends
import com.sopt.dive.presentation.home.component.FriendCard

@Composable
fun HomeRoute(
    paddingValues: PaddingValues
) {
    HomeScreen(
        modifier = Modifier.padding(paddingValues)
    )
}

@Composable
fun HomeScreen(
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

        itemsIndexed(
            items = dummyFriends,
            key = { _, friend -> friend.nickname }
        ) { index, friend ->
            FriendCard(
                order = index + 1,
                friend = friend,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    DiveTheme {
        HomeScreen()
    }
}