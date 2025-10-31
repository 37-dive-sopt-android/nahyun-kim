package com.sopt.dive.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

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
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = "Home",
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}