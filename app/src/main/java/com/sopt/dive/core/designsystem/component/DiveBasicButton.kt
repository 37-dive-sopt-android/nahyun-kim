package com.sopt.dive.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sopt.dive.core.util.noRippleClickable

@Composable
fun DiveBasicButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 18.sp,
        color = Color.White,
        style = TextStyle(fontWeight = FontWeight.Normal),
        textAlign = TextAlign.Center,
        modifier = modifier
            .clip(CircleShape)
            .background(Color(0xFF007294))
            .padding(vertical = 12.dp)
            .fillMaxWidth()
            .noRippleClickable(onClick = onClick)
    )
}