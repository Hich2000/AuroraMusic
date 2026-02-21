package com.hich2000.aurora.settings.generalScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
    val showAlbumArtPlayerScreen by generalScreenViewModel.showAlbumArtPlayerScreen.collectAsState()
    val showAlbumArtNotification by generalScreenViewModel.showAlbumArtNotification.collectAsState()

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
                    text = "Show album art on player screen",
                    textAlign = TextAlign.Center,
                    fontSize = MaterialTheme.typography.labelLarge.fontSize,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.8f)
                )
                AuroraCheckbox(
                    checked = showAlbumArtPlayerScreen,
                    onCheckedChange = {
                        generalScreenViewModel.handleShowAlbumArtPlayerScreenCheckbox()
                    },
                    modifier = Modifier.weight(0.2f)
                )
            }
        }

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
                    text = "Show album art on android notification",
                    textAlign = TextAlign.Center,
                    fontSize = MaterialTheme.typography.labelLarge.fontSize,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.8f)
                )
                AuroraCheckbox(
                    checked = showAlbumArtNotification,
                    onCheckedChange = {
                        generalScreenViewModel.handleShowAlbumArtNotificationCheckbox()
                    },
                    modifier = Modifier.weight(0.2f)
                )
            }
        }
    }
}