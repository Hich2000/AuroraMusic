package com.hich2000.aurora.settings.generalScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.hich2000.aurora.settings.composables.SettingsCard
import com.hich2000.aurora.settings.composables.SettingsScreenScaffold
import com.hich2000.aurora.utils.composables.AuroraCheckbox

@Composable
fun GeneralScreen(
    generalScreenViewModel: GeneralScreenViewModel = hiltViewModel()
) {
    val showAlbumArt by generalScreenViewModel.showAlbumArt.collectAsState()

    SettingsScreenScaffold(
        topBarText = "Settings/General",
        columnArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SettingsCard(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Show album art",
                    textAlign = TextAlign.Left,
                    fontSize = MaterialTheme.typography.labelLarge.fontSize,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.8f)
                        .padding(8.dp)
                )
                AuroraCheckbox(
                    checked = showAlbumArt,
                    onCheckedChange = {
                        generalScreenViewModel.handleShowAlbumArtCheckbox()
                    },
                    modifier = Modifier.weight(0.2f)
                )
            }
        }
    }
}