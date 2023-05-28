package com.main.core.data

import androidx.core.net.toUri

object NavigationDeepLinks {
    val NOTES_DEEP_LINK = "android-app://androidx.navigation/android://application/note_link/notes".toUri()
    val ADD_NOTE_DEEP_LINK = "android-app://androidx.navigation/android://application/note_link/add_note".toUri()
}