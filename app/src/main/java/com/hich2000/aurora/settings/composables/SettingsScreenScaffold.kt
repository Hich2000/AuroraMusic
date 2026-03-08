package com.hich2000.aurora.settings.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hich2000.aurora.main.navigation.TopBar

@Composable
fun SettingsScreenScaffold(
    topBarText: String,
    columnArrangement: Arrangement.Vertical,
    content: @Composable (() -> Unit)
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = { TopBar(topText = topBarText) }
    ) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                verticalArrangement = columnArrangement,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                content()
            }
        }
    }
}