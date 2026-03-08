package com.hich2000.aurora.utils.composables

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AuroraCheckbox(
    checked: Boolean,
    onCheckedChange: (() -> Unit),
    modifier: Modifier
) {
    Checkbox(
        checked = checked,
        onCheckedChange = {
            onCheckedChange()
        },
        colors = CheckboxColors(
            checkedCheckmarkColor = MaterialTheme.colorScheme.primary,
            uncheckedCheckmarkColor = MaterialTheme.colorScheme.primary,
            checkedBoxColor = MaterialTheme.colorScheme.tertiary,
            uncheckedBoxColor = MaterialTheme.colorScheme.tertiary,
            disabledCheckedBoxColor = MaterialTheme.colorScheme.primary.copy(
                alpha = 0.8f
            ),
            disabledUncheckedBoxColor = MaterialTheme.colorScheme.primary.copy(
                alpha = 0.8f
            ),
            disabledIndeterminateBoxColor = MaterialTheme.colorScheme.primary.copy(
                alpha = 0.8f
            ),
            checkedBorderColor = MaterialTheme.colorScheme.primary,
            uncheckedBorderColor = MaterialTheme.colorScheme.primary,
            disabledBorderColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
            disabledUncheckedBorderColor = MaterialTheme.colorScheme.primary.copy(
                alpha = 0.8f
            ),
            disabledIndeterminateBorderColor = MaterialTheme.colorScheme.primary.copy(
                alpha = 0.8f
            ),
        ),
        modifier = modifier
    )
}