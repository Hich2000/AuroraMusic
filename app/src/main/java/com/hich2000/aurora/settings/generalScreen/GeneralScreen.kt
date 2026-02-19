package com.hich2000.aurora.settings.generalScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text("test", textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}