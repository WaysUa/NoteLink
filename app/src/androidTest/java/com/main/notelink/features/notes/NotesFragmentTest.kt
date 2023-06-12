package com.main.notelink.features.notes

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.main.notelink.BaseTest
import com.main.notelink.features.note.add.AddNoteScreen
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NotesFragmentTest : BaseTest() {

    private val notesScreen = NotesScreen()
    private val addNotesScreen = AddNoteScreen()

    @Test
    fun addNote() {
        notesScreen.btnAddNote.click()
        addNotesScreen.etTitle.typeText("First Title")
        addNotesScreen.etContent.typeText("First Content")
        addNotesScreen.btnBack.click()
        notesScreen.rvNotes.run {
            viewInRecycler(0, notesScreen.tvTitle).checkText("First Title")
            viewInRecycler(0, notesScreen.tvContent).checkText("First Content")
        }
    }

    @Test
    fun navigateFromNotesToAddNote() {
        notesScreen.btnAddNote.click()
        addNotesScreen.fragmentAddNoteLayout.checkIsVisible()
    }
}
