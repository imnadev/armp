package io.ansor.al.huda.util

import android.animation.ObjectAnimator

fun ObjectAnimator?.set(playing: Boolean) {
    if (playing) {
        this?.resume()
    } else {
        this?.pause()
    }
}