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
    private val _showAlbumArt: MutableStateFlow<Boolean> = MutableStateFlow(
        sharedPreferenceManager.getPreference(SharedPreferenceKey.ShowAlbumArt, defaultValue = true)
    )
    val showAlbumArt get() = _showAlbumArt

    private val _playerScreenAmbience: MutableStateFlow<Boolean> = MutableStateFlow(
        sharedPreferenceManager.getPreference(SharedPreferenceKey.PlayerScreenAmbience, defaultValue = true)
    )
    val playerScreenAmbience get() = _playerScreenAmbience

    fun setShowAlbumArt(showAlbumArt: Boolean) {
        _showAlbumArt.value = showAlbumArt
        sharedPreferenceManager.savePreference(SharedPreferenceKey.ShowAlbumArt, showAlbumArt)
    }

    fun setPlayerScreenAmbience(playerScreenAmbience: Boolean) {
        _playerScreenAmbience.value = playerScreenAmbience
        sharedPreferenceManager.savePreference(SharedPreferenceKey.PlayerScreenAmbience, playerScreenAmbience)
    }
}