package com.hich2000.aurora.utils

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.hich2000.aurora.music.mediaController.MediaPlayerCoordinator
import javax.inject.Inject

class LifeCycleManager @Inject constructor(
    private val mediaPlayerCoordinator: MediaPlayerCoordinator
): DefaultLifecycleObserver {
    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        mediaPlayerCoordinator.cleanup()
    }
}