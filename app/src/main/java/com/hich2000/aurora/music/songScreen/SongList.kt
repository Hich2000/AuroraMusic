package com.hich2000.aurora.music.songScreen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hich2000.aurora.music.queueManager.Song

@Composable
fun SongList(
    modifier: Modifier = Modifier,
    songList: List<Song> = emptyList(),
    songCard: @Composable (song: Song) -> Unit,
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = songList,
            key = { song -> song.id }
        ) { song ->
            songCard(song)
        }
    }
}