package com.sopt.dive.presentation.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.dive.R
import com.sopt.dive.presentation.auth.model.RegisterInfo

@Composable
fun MainScreen(
    resultUserInfo: RegisterInfo,
    modifier: Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier
    ) {
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
                text = resultUserInfo.id,
                fontSize = 24.sp,
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = stringResource(R.string.pwd_label),
                fontSize = 32.sp,
                fontWeight = FontWeight.Normal,
            )

            Text(
                text = resultUserInfo.password,
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
                text = resultUserInfo.nickname,
                fontSize = 24.sp,
            )
        }
    }
}