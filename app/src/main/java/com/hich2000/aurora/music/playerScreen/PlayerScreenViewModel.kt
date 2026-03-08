package com.hich2000.aurora.music.playerScreen

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaMetadataRetriever
import androidx.lifecycle.ViewModel
import com.hich2000.aurora.music.mediaController.MediaPlayerCoordinator
import com.hich2000.aurora.music.playerState.PlayerState
import com.hich2000.aurora.settings.generalScreen.GeneralSettingsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

@HiltViewModel
class PlayerScreenViewModel @Inject constructor(
    private val mediaPlayerCoordinator: MediaPlayerCoordinator,
    private val generalSettingsState: GeneralSettingsState
) : ViewModel() {

    val playerState: StateFlow<PlayerState> get() = mediaPlayerCoordinator.playerState
    val showAlbumArt: StateFlow<Boolean> get() = generalSettingsState.showAlbumArt
    val queueInit: StateFlow<Boolean> get() = mediaPlayerCoordinator.queueInit
    val playerScreenAmbience: StateFlow<Boolean> get() = generalSettingsState.playerScreenAmbience

    fun pausePlay() {
        if (playerState.value.isPlaying) {
            mediaPlayerCoordinator.pause()
        } else {
            mediaPlayerCoordinator.play()
        }
    }

    fun next() = mediaPlayerCoordinator.next()
    fun previous() = mediaPlayerCoordinator.previous()
    fun shuffleMode() = mediaPlayerCoordinator.shuffleMode()
    fun loopMode() = mediaPlayerCoordinator.loopMode()
    fun seek(position: Long) = mediaPlayerCoordinator.seek(position)

    suspend fun getAlbumArt(): Bitmap? {
        if (!queueInit.value) {
            queueInit.first { it }
        }
        val currentSongPath = mediaPlayerCoordinator.currentQueue.value.find { song ->
            song.title == playerState.value.currentSong
        }?.path

        if (currentSongPath == null) {
            return null
        }

        val retriever = MediaMetadataRetriever()
        retriever.setDataSource(currentSongPath)
        val albumArtBytes = retriever.embeddedPicture
        retriever.release()

        return if (albumArtBytes != null) {
            BitmapFactory.decodeByteArray(albumArtBytes, 0, albumArtBytes.size)
        } else {
            null
        }
    }
}