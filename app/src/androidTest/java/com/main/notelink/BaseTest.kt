package com.main.notelink

abstract class BaseTest {
    protected fun getItemIdFromAnotherModule(moduleId: String, itemId: String): Int {
        return Class.forName("$moduleId.R\$id").getField(itemId).getInt(null)
    }

    sealed class Modules(val moduleId: String) {
        object NotesModule : Modules("com.main.feat_notes")
    }
}