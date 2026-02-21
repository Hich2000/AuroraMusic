package com.hich2000.aurora.settings.themesScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
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
import com.hich2000.aurora.settings.composables.SettingsCard
import com.hich2000.aurora.theme.DarkColorScheme
import com.hich2000.aurora.theme.LightColorScheme
import com.hich2000.aurora.utils.composables.AuroraCheckbox

@Composable
fun ThemesScreen(
    themesScreenViewModel: ThemesScreenViewModel = hiltViewModel()
) {
    val useSystemTheme by themesScreenViewModel.useSystemTheme.collectAsState()
    val selectedTheme by themesScreenViewModel.selectedTheme.collectAsState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { TopBar(topText = "Settings/Themes") }
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
                            text = "Match app colors to device settings.",
                            textAlign = TextAlign.Center,
                            fontSize = MaterialTheme.typography.labelLarge.fontSize,
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(0.8f)
                                //idk, but centervertically on the row is not doing anything here.
                                .padding(12.dp)
                        )
                        AuroraCheckbox(
                            checked = useSystemTheme,
                            onCheckedChange = {
                                themesScreenViewModel.handleUseSystemThemeCheckbox()
                            },
                            modifier = Modifier.weight(0.2f)
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    SettingsCard (
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.primary)
                            .weight(0.5f)
                            .height(200.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .background(
                                        color = LightColorScheme.primary,
                                        shape = CircleShape
                                    )
                            )
                            Text("Light mode")
                            RadioButton(
                                selected = selectedTheme == SelectableThemes.LIGHTMODE,
                                onClick = {
                                    themesScreenViewModel.setSelectedTheme(SelectableThemes.LIGHTMODE)
                                },
                                enabled = !useSystemTheme
                            )
                        }
                    }

                    SettingsCard(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.primary)
                            .weight(0.5f)
                            .height(200.dp)
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(50.dp)
                                    .background(
                                        color = DarkColorScheme.primary,
                                        shape = CircleShape
                                    )
                            )
                            Text("Dark mode")
                            RadioButton(
                                selected = selectedTheme == SelectableThemes.DARKMODE,
                                onClick = {
                                    themesScreenViewModel.setSelectedTheme(SelectableThemes.DARKMODE)
                                },
                                enabled = !useSystemTheme
                            )
                        }
                    }
                }

            }
        }
    }
}