package com.main.notelink.features.notes.presentation.widget

import android.annotation.SuppressLint
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import androidx.room.Room
import com.main.notelink.R
import com.main.notelink.main.data.cache.NoteLinkDatabase
import com.main.notelink.main.data.cache.dao.NotesDao

class Something : RemoteViewsService() {
    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory {
        TODO("Not yet implemented")
    }
}

class MainNoteWidget : AppWidgetProvider() {
    private lateinit var database: NoteLinkDatabase
    private lateinit var notesDao: NotesDao

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(notesDao, context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        database = Room.databaseBuilder(
            context,
            NoteLinkDatabase::class.java,
            "note_link_database"
        ).fallbackToDestructiveMigration().build()
        notesDao = database.notesDao()
    }
}

@SuppressLint("RemoteViewLayout")
internal fun updateAppWidget(
    notesDao: NotesDao,
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    Log.d("MyLog", "smt")
    Log.d("MyLog", "AddNoteWidget: ${notesDao.getAllNotes().joinToString()}")
    val views = RemoteViews(context.packageName, R.layout.add_note_widget)
    appWidgetManager.updateAppWidget(appWidgetId, views)
}
