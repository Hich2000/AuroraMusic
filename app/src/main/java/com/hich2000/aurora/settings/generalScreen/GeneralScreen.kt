package com.hich2000.aurora.settings.generalScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.hich2000.aurora.main.navigation.TopBar

@Composable
fun GeneralScreen(
    generalScreenViewModel: GeneralScreenViewModel = hiltViewModel()
) {
    val cutCornerRadius = 8.dp
    val showAlbumArtPlayerScreen by generalScreenViewModel.showAlbumArtPlayerScreen.collectAsState()
    val showAlbumArtNotification by generalScreenViewModel.showAlbumArtNotification.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { TopBar(topText = "Settings/Folders") }
    ) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Card(
                    shape = CutCornerShape(
                        topStart = cutCornerRadius,
                        topEnd = cutCornerRadius,
                        bottomStart = cutCornerRadius,
                        bottomEnd = cutCornerRadius
                    ),
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
                                .fillMaxSize()
                                .weight(0.8f)
                                //idk, but centervertically on the row is not doing anything here.
                                .padding(12.dp)
                        )
                        Checkbox(
                            checked = showAlbumArtPlayerScreen,
                            onCheckedChange = {
                                generalScreenViewModel.handleShowAlbumArtPlayerScreenCheckbox()
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
                            modifier = Modifier.weight(0.2f)
                        )
                    }
                }
            }
        }
    }
}