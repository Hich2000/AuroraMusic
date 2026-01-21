package com.hich2000.aurora.music.queueManager

import com.hich2000.aurora.tagsAndCategories.tags.Tag

data class Song(val id: Long, val path: String, val title: String, val tags: List<Tag>) {
    val tagCount: Int get() = tags.count()
}