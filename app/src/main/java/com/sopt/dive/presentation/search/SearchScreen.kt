package com.sopt.dive.presentation.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sopt.dive.R
import com.sopt.dive.presentation.search.component.FlipCard

@Composable
fun SearchRoute(
    paddingValues: PaddingValues
) {
    SearchScreen(
        modifier = Modifier.padding(paddingValues)
    )
}

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier
) {
    var isFront by remember { mutableStateOf(true) }

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        FlipCard(
            isFront = isFront,
            frontImageRes = R.drawable.img_profile_dummy,
            backImageRes = R.drawable.img_card_back,
            onDismiss = { isFront = !isFront },
            modifier = Modifier
                .size(width = 250.dp, height = 375.dp)
                .align(Alignment.Center)
        )
    }
}