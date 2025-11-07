package com.sopt.dive.presentation.mypage.component

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.sopt.dive.R
import com.sopt.dive.core.designsystem.theme.DiveTheme
import com.sopt.dive.core.util.noRippleClickable
import kotlin.math.sqrt

const val stiffness = 177.8f
val dampingRatio = getDampingRatio(
    damping = 20f,
    stiffness = stiffness,
    mass = 1f
)

@Composable
fun ProfileCard(
    modifier: Modifier = Modifier,
    width: Dp = 180.dp,
    height: Dp = 250.dp
) {
    var isFlipped by remember { mutableStateOf(false) }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        BackTextCard(
            isFlipped = isFlipped,
            modifier = Modifier.size(width = width, height = height)
        )

        FrontImageCard(
            isFlipped = isFlipped,
            onClick = { isFlipped = !isFlipped },
            modifier = Modifier.size(width = width, height = height)
        )
    }
}

@Composable
private fun FrontImageCard(
    isFlipped: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val transition = updateTransition(
        targetState = isFlipped,
        label = "frontTransition"
    )

    val offset by transition.animateFloat(
        transitionSpec = {
            spring(
                stiffness = stiffness,
                dampingRatio = dampingRatio
            )
        },
        label = "frontOffset"
    ) { flipped ->
        if (flipped) 25f else 0f
    }

    val rotation by transition.animateFloat(
        transitionSpec = {
            spring(
                stiffness = stiffness,
                dampingRatio = dampingRatio,
            )
        }
    ) { flipped ->
        if (flipped) 180f else 0f
    }

    Image(
        painter = painterResource(R.drawable.img_profile_dummy),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
            .offset(x = offset.dp, y = offset.dp)
            .noRippleClickable(onClick = { onClick() })
            .zIndex(if (rotation <= 90f) 1f else -1f)
            .graphicsLayer {
                rotationY = rotation
            }
            .clip(
                RoundedCornerShape(
                    topStart = 10.dp,
                    topEnd = 60.dp,
                    bottomEnd = 10.dp,
                    bottomStart = 100.dp
                )
            )
    )
}

@Composable
private fun BackTextCard(
    isFlipped: Boolean,
    modifier: Modifier = Modifier,
) {
    val transition = updateTransition(
        targetState = isFlipped,
        label = "backTransition"
    )

    val textAlpha by transition.animateFloat(
        label = "textAlpha"
    ) { flipped ->
        if (flipped) 1f else 0f
    }

    Box(
        modifier = modifier
            .zIndex(0f)
            .clip(
                RoundedCornerShape(
                    topStart = 60.dp,
                    topEnd = 10.dp,
                    bottomEnd = 100.dp,
                    bottomStart = 10.dp
                )
            )
            .background(Color.Blue)
            .padding(20.dp)
    ) {
        Text(
            text = "안녕하세요?\n완두콩입니다\n콩콩콩",
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .graphicsLayer {
                    alpha = textAlpha
                }
                .align(Alignment.Center)
        )
    }
}

private fun getDampingRatio(
    damping: Float,
    stiffness: Float,
    mass: Float
) = damping / (2 * sqrt((stiffness * mass)))

@Preview(showBackground = true)
@Composable
private fun ProfileCardPreview() {
    DiveTheme {
        ProfileCard()
    }
}