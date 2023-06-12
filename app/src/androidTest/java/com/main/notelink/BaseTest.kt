package com.main.notelink

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.main.notelink.features.notes.RecyclerViewMatcher
import com.main.notelink.main.presentation.MainActivity
import org.hamcrest.CoreMatchers
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    protected fun ViewInteraction.checkIsVisible(): ViewInteraction {
        return check(matches(ViewMatchers.isDisplayed()))
    }

    protected fun ViewInteraction.typeText(value: String) {
        perform(ViewActions.typeText(value))
        closeSoftKeyboard()
    }

    protected fun ViewInteraction.checkText(value: String) {
        check(matches(withText(value)))
    }

    protected fun ViewInteraction.click() {
        perform(ViewActions.click())
    }

    protected fun ViewInteraction.isNotTextInRecyclerView(text: String): ViewInteraction {
        return check(matches(CoreMatchers.not(ViewMatchers.hasDescendant(withText(text)))))
    }

    protected fun ViewInteraction.longClick() {
        perform(ViewActions.longClick())
    }

    protected fun Int.viewInRecycler(position: Int, viewId: Int): ViewInteraction {
        return onView(RecyclerViewMatcher(this).atPosition(position, viewId))
    }
}
