package com.main.notelink.features.notes

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.main.notelink.BaseTest
import com.main.notelink.features.note.add.AddNoteScreen
import com.main.notelink.features.note.delete.DeleteNoteScreen
import com.main.notelink.features.note.edit.EditNoteScreen
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NotesFragmentTest : BaseTest() {

    private val notesScreen = NotesScreen()
    private val addNoteScreen = AddNoteScreen()
    private val editNoteScreen = EditNoteScreen()
    private val deleteNoteScreen = DeleteNoteScreen()

    @Test
    fun addNote() {
        notesScreen.btnAddNote.click()
        addNoteScreen.etTitle.typeText("First Title")
        addNoteScreen.etContent.typeText("First Content")
        addNoteScreen.btnBack.click()
        notesScreen.rvNotes.run {
            viewInRecycler(0, notesScreen.tvTitle).checkText("First Title")
            viewInRecycler(0, notesScreen.tvContent).checkText("First Content")
        }
    }

    @Test
    fun editNote() {
        notesScreen.btnAddNote.click()
        addNoteScreen.etTitle.typeText("First Title")
        addNoteScreen.etContent.typeText("First Content")
        addNoteScreen.btnBack.click()
        notesScreen.rvNotes.run {
            viewInRecycler(0, notesScreen.tvTitle).checkText("First Title")
            viewInRecycler(0, notesScreen.tvContent).checkText("First Content")
            viewInRecycler(0, notesScreen.itemNoteLayout).click()
        }
        editNoteScreen.etTitle.typeText(" Edit")
        editNoteScreen.etContent.typeText(" Edit")
        editNoteScreen.etTitle.checkText("First Title Edit")
        editNoteScreen.etContent.checkText("First Content Edit")
    }

    @Test
    fun deleteNote() {
        notesScreen.btnAddNote.click()
        addNoteScreen.etTitle.typeText("Delete Title")
        addNoteScreen.etContent.typeText("Delete Content")
        addNoteScreen.btnBack.click()
        notesScreen.rvNotes.run {
            viewInRecycler(0, notesScreen.tvTitle).checkText("Delete Title")
            viewInRecycler(0, notesScreen.tvContent).checkText("Delete Content")
            viewInRecycler(0, notesScreen.itemNoteLayout).longClick()
        }
        deleteNoteScreen.btnDelete.click()
        onView(withId(notesScreen.rvNotes)).isNotTextInRecyclerView("Delete Title")
    }

    @Test
    fun navigateFromNotesToAddNote() {
        notesScreen.btnAddNote.click()
        addNoteScreen.fragmentAddNoteLayout.checkIsVisible()
    }
}
