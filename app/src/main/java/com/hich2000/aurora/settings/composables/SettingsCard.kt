package com.hich2000.aurora.settings.composables

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsCard(
    modifier: Modifier = Modifier,
    content: @Composable (() -> Unit)
) {
    val cutCornerRadius = 8.dp

    Card(
        shape = CutCornerShape(
            topStart = cutCornerRadius,
            topEnd = cutCornerRadius,
            bottomStart = cutCornerRadius,
            bottomEnd = cutCornerRadius
        ),
        modifier = modifier
    ) {
        content()
    }
}