package com.sopt.dive.presentation.search.component

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.dive.R
import com.sopt.dive.core.util.noRippleClickable

@Composable
fun FlipCard(
    isFront: Boolean,
    frontImageRes: Int,
    backImageRes: Int,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    val rotationY by animateFloatAsState(
        targetValue = if (isFront) 0f else 180f, // isFront가 true면 0도 (앞면)
        animationSpec = tween(500, easing = FastOutSlowInEasing),
        label = "rotationY"
    )
    val cameraDistance = with(LocalDensity.current) { 12.dp.toPx() }

    Box(
        modifier = modifier
            .graphicsLayer {
                this.rotationY = rotationY
                this.cameraDistance = cameraDistance
                if (rotationY > 90f) {
                    scaleX = -1f
                }
            }
            .clip(RoundedCornerShape(12.dp))
            .noRippleClickable { onDismiss() }
    ) {
        Image(
            painter = painterResource(
                id = if (rotationY <= 90f) frontImageRes else backImageRes
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FlipCardInteractivePreview() {
    var isFront by remember { mutableStateOf(true) }

    FlipCard(
        isFront = isFront,
        frontImageRes = R.drawable.img_profile_dummy,
        backImageRes = R.drawable.img_card_back,
        onDismiss = { isFront = false }
    )
}