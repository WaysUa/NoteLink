package com.main.notelink.features.notes.presentation.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.RemoteViews
import androidx.room.Room
import com.main.notelink.R
import com.main.notelink.main.data.cache.NoteLinkDatabase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainNoteWidget : AppWidgetProvider() {
    // todo add widget
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        if (intent?.action == "com.main.notelink.DATA_UPDATED") {
            context?.let { mainContext ->
                Log.d("MyLog", "MainNoteWidget: received intent")
                val appWidgetManager = AppWidgetManager.getInstance(mainContext)
                val appWidgetIds = appWidgetManager.getAppWidgetIds(
                    ComponentName(mainContext, MainNoteWidget::class.java)
                )
                onUpdate(mainContext, appWidgetManager, appWidgetIds)
            }
        }
    }
}

@OptIn(DelicateCoroutinesApi::class)
internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val database = Room.databaseBuilder(
        context,
        NoteLinkDatabase::class.java,
        "note_link_database"
    ).fallbackToDestructiveMigration().build()
    val notesDao = database.notesDao()

    GlobalScope.launch(Dispatchers.IO) {
        val notes = notesDao.getAllNotes().reversed()
        val views = RemoteViews(context.packageName, R.layout.add_note_widget).also {
            it.setTextViewText(R.id.firstTitle, notes[0].title)
            it.setTextViewText(R.id.secondTitle, notes[1].title)
            it.setTextViewText(R.id.thirdTitle, notes[2].title)
            it.setTextViewText(R.id.fourthTitle, notes[3].title)
            it.setTextViewText(R.id.firstContent, notes[0].content)
            it.setTextViewText(R.id.secondContent, notes[1].content)
            it.setTextViewText(R.id.thirdContent, notes[2].content)
            it.setTextViewText(R.id.fourthContent, notes[3].content)
        }
        appWidgetManager.updateAppWidget(appWidgetId, views)
    }
}
