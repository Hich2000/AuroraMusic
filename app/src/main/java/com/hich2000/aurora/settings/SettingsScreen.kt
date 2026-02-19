package com.hich2000.aurora.settings

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hich2000.aurora.main.navigation.LocalNavController
import com.hich2000.aurora.main.navigation.Route
import com.hich2000.aurora.utils.composables.AuroraButton

@Composable
fun SettingsScreen() {
    val navController = LocalNavController.current

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AuroraButton(
            onClick = {
                //now I can use the navController like this
                navController.navigate(Route.Settings.General.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, MaterialTheme.colorScheme.tertiary)
        ) {
            Text("General")
        }
        AuroraButton(
            onClick = {
                //now I can use the navController like this
                navController.navigate(Route.Settings.Folders.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, MaterialTheme.colorScheme.tertiary)
        ) {
            Text("Music folders")
        }
        AuroraButton(
            onClick = {
                //now I can use the navController like this
                navController.navigate(Route.Settings.Themes.route)
            },
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, MaterialTheme.colorScheme.tertiary)
        ) {
            Text("Themes")
        }
    }
}

