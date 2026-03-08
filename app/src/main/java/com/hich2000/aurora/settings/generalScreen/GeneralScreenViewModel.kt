package com.hich2000.aurora.settings.generalScreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class GeneralScreenViewModel @Inject constructor(
    val generalSettingsState: GeneralSettingsState
): ViewModel() {
    val showAlbumArt: StateFlow<Boolean> get() = generalSettingsState.showAlbumArt
    val playerScreenAmbience: StateFlow<Boolean> get() = generalSettingsState.playerScreenAmbience

    fun handleShowAlbumArtCheckbox() {
        generalSettingsState.setShowAlbumArt(!showAlbumArt.value)
    }

    fun handlePlayerScreenAmbienceCheckbox() {
        generalSettingsState.setPlayerScreenAmbience(!playerScreenAmbience.value)
    }
}