package com.example.moviecatalogue.base.presentation

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper

object CastedContex {
    fun scanForActivity(cont: Context?): Activity? {
        if (cont == null) return null
        else if (cont is Activity)
            return cont
        else if (cont is ContextWrapper)
            return scanForActivity(
                (cont).baseContext
            )
        return null
    }
}