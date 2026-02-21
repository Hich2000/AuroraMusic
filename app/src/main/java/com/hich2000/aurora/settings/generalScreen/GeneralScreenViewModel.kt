package com.hich2000.aurora.settings.generalScreen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class GeneralScreenViewModel @Inject constructor(
    val generalSettingsState: GeneralSettingsState
): ViewModel() {
    val showAlbumArtPlayerScreen: StateFlow<Boolean> get() = generalSettingsState.showAlbumArtPlayerScreen
    val showAlbumArtNotification: StateFlow<Boolean> get() = generalSettingsState.showAlbumArtNotification

    fun handleShowAlbumArtPlayerScreenCheckbox() {
        generalSettingsState.setShowAlbumArtPlayerScreen(!showAlbumArtPlayerScreen.value)
    }
}