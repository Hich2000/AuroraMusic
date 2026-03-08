package com.hich2000.aurora.settings.folderScreen

import android.annotation.SuppressLint
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.hich2000.aurora.settings.composables.SettingsScreenScaffold
import com.hich2000.aurora.utils.composables.AuroraButton

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FolderScreen(
    folderScreenViewModel: FolderScreenViewModel = hiltViewModel()
) {
    val folders by folderScreenViewModel.foldersToScan.collectAsState()

    //this is how to request the system for permission for specific folders
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.OpenDocumentTree()) { uri ->
            uri?.let { folderScreenViewModel.addScanFolder(uri) }
        }

    SettingsScreenScaffold(
        topBarText = "Settings/Folders",
        columnArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .border(2.dp, MaterialTheme.colorScheme.secondary)
                .heightIn(max = 230.dp)
        ) {
            LazyColumn {
                itemsIndexed(folders) { index, folder ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Text(
                            text = folder,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .weight(0.9f)
                        )
                        IconButton(
                            onClick = {
                                folderScreenViewModel.removeScanFolder(index)
                            },
                            modifier = Modifier.weight(0.1f)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete scan folder",
                                tint = MaterialTheme.colorScheme.secondary
                            )
                        }
                    }
                }
            }
        }

        HorizontalDivider(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .padding(8.dp)
        )

        AuroraButton(
            onClick = {
                launcher.launch(null)
            },
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, MaterialTheme.colorScheme.tertiary, RectangleShape),
        ) {
            Text("Add folder to scan")
        }
    }
}