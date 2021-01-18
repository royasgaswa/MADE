package com.example.moviecatalogue.detail.animation

import android.transition.ChangeBounds
import android.transition.Transition
import android.view.Window
import android.view.animation.DecelerateInterpolator

class SharedElementViewProvider(val window: Window) {
    fun init() {
        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)

        window.sharedElementEnterTransition = enterTransition()
        window.sharedElementReturnTransition = returnTransition()
    }

    private fun enterTransition(): Transition? {
        val bounds = ChangeBounds()
        bounds.duration = 1000
        return bounds
    }

    private fun returnTransition(): Transition? {
        val bounds = ChangeBounds()
        bounds.interpolator = DecelerateInterpolator()
        bounds.duration = 1000
        return bounds
    }
}