package io.ansor.al.huda.presentation.common

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.ansor.al.huda.presentation.ui.theme.AlhudaTheme
import io.ansor.al.huda.presentation.ui.theme.switchSelected
import io.ansor.al.huda.presentation.ui.theme.switchUnselected

@Preview
@Composable
fun CustomSwitchPreview() {
    AlhudaTheme {
        CustomSwitch()
    }
}

@Composable
fun CustomSwitch(
    width: Dp = 32.dp,
    height: Dp = 16.dp,
    checkedTrackColor: Color = MaterialTheme.colors.switchSelected,
    uncheckedTrackColor: Color = MaterialTheme.colors.switchUnselected,
    gapBetweenThumbAndTrackEdge: Dp = 0.dp,
    borderWidth: Dp = 1.dp,
    cornerSize: Dp = 38.dp,
    thumbSize: Dp = height,
    enabled: Boolean = false,
    onChanged: (enabled: Boolean) -> Unit = {}
) {

    val interactionSource = remember {
        MutableInteractionSource()
    }

    val alignment by animateAlignmentAsState(if (enabled) 1f else -1f)

    Box(
        modifier = Modifier
            .size(width = width, height = height)
            .border(
                width = borderWidth,
                color = if (enabled) checkedTrackColor else uncheckedTrackColor,
                shape = RoundedCornerShape(size = cornerSize)
            )
            .clickable(
                indication = null,
                interactionSource = interactionSource
            ) {
                onChanged(!enabled)
            },
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .padding(
                    start = gapBetweenThumbAndTrackEdge,
                    end = gapBetweenThumbAndTrackEdge
                )
                .fillMaxSize(),
            contentAlignment = alignment
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = if (enabled) checkedTrackColor else uncheckedTrackColor,
                        shape = CircleShape
                    )
                    .size(thumbSize)
            )
        }
    }
}

@Composable
private fun animateAlignmentAsState(
    targetBiasValue: Float
): State<BiasAlignment> {
    val bias by animateFloatAsState(targetBiasValue)
    val derivedState = remember {
        derivedStateOf { BiasAlignment(horizontalBias = bias, verticalBias = 0f) }
    }
    return derivedState
}