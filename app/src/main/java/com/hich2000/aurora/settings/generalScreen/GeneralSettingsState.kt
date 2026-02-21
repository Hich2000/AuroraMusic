package com.hich2000.aurora.settings.generalScreen

import com.hich2000.aurora.utils.sharedPreferences.SharedPreferenceKey
import com.hich2000.aurora.utils.sharedPreferences.SharedPreferenceManager
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GeneralSettingsState @Inject constructor(
    val sharedPreferenceManager: SharedPreferenceManager
) {
    private val _showAlbumArtPlayerScreen: MutableStateFlow<Boolean> = MutableStateFlow(
        sharedPreferenceManager.getPreference(SharedPreferenceKey.ShowAlbumArtPlayerScreen, defaultValue = true)
    )
    val showAlbumArtPlayerScreen get() = _showAlbumArtPlayerScreen

    private val _showAlbumArtNotification: MutableStateFlow<Boolean> = MutableStateFlow(
        sharedPreferenceManager.getPreference(SharedPreferenceKey.ShowAlbumArtNotification, defaultValue = true)
    )
    val showAlbumArtNotification get() = _showAlbumArtNotification

    fun setShowAlbumArtPlayerScreen(showAlbumArtPlayerScreen: Boolean) {
        _showAlbumArtPlayerScreen.value = showAlbumArtPlayerScreen
        sharedPreferenceManager.savePreference(SharedPreferenceKey.ShowAlbumArtPlayerScreen, showAlbumArtPlayerScreen)
    }

    fun setShowAlbumArtNotification(showAlbumArtNotification: Boolean) {
        _showAlbumArtNotification.value = showAlbumArtNotification
        sharedPreferenceManager.savePreference(SharedPreferenceKey.ShowAlbumArtNotification, showAlbumArtNotification)
    }
}