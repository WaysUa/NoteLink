package com.main.core.data

import android.net.Uri
import androidx.core.net.toUri

sealed class NavigationDeepLink(val link: Uri) {
    object Notes : NavigationDeepLink(
        link = "android-app://androidx.navigation/android://application/note_link/notes".toUri()
    )

    object AddNote : NavigationDeepLink(
        link = "android-app://androidx.navigation/android://application/note_link/add_note".toUri()
    )
}