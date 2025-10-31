package com.sopt.dive.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

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
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "Search",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}