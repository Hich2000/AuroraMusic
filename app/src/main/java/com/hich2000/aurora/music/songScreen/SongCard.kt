package com.hich2000.aurora.music.songScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Label
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.hich2000.aurora.music.queueManager.Song

@Composable
fun SongCard(
    song: Song,
    showTagCount: Boolean = false,
    onClick: () -> Unit = {},
    backgroundColor: Color = MaterialTheme.colorScheme.primary
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        modifier = Modifier
            .border(2.dp, MaterialTheme.colorScheme.tertiary, shape = RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.tertiary)
            .height(50.dp),
        onClick = onClick
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp)
            ) {
                Icon(
                    Icons.Rounded.PlayArrow,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary,
                )
                Text(
                    song.title,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .basicMarquee(
                            iterations = 1
                        ),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            //this is an incredibly lazy fix for a visual bug regarding the queue system,
            // but tbh I don't think its necessary to see tag count on the queue screen.
            if (showTagCount) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(8.dp)
                        .background(backgroundColor)
                ) {
                    Icon(
                        Icons.AutoMirrored.Filled.Label,
                        contentDescription = "Add tags",
                        tint = MaterialTheme.colorScheme.secondary,
                    )
                    Text(
                        "(${song.tagCount})",
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                }
            }
        }
    }
}