package com.main.notelink

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.main.notelink.main.presentation.ui.MainActivity
import org.junit.Rule
import org.junit.Test

class MainNavigationTest : BaseTest() {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testStartNavigationScreen() {
        onView(withId(R.id.container)).check(matches(isDisplayed()))
    }

    @Test
    fun testNavigationScreenAfterMainViewModelInit() {
        val fragmentNotes = getItemIdFromAnotherModule(Modules.NotesModule.moduleId, "fragment_notes")
        onView(withId(fragmentNotes)).check(matches(isDisplayed()))
    }
}