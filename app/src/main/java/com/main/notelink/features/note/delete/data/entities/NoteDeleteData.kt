package com.main.notelink.features.note.delete.data.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NoteDeleteData(
    val id: Int = 0,
    val title: String,
    val content: String,
    val isChecked: Boolean = false
): Parcelable