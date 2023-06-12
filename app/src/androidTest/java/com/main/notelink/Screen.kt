package com.main.notelink

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers

abstract class Screen {
    protected fun Int.view(): ViewInteraction = Espresso.onView(ViewMatchers.withId(this))
}
