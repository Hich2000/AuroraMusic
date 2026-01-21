package com.hich2000.aurora.tagsAndCategories.tags

import com.hich2000.aurora.music.queueManager.Song

data class Tag(
    val id: Long,
    val tag: String,
    val categoryId: Long?,
    var taggedSongs: List<Song> = emptyList()
)