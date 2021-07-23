package com.example.notesit

import android.content.Context
import android.util.Log

class DatabaseThread(val context: Context) : Runnable {
    init {
        Thread(this).start()
    }

    override fun run() {
        val db = AppDatabase.getDatabase(context = context)
        val noteDao = db.noteDao()
        val note = Note(6, "В магазин", "Купить хлеба и картошки", "вв", true)
        noteDao.insertNote(note)
        val notes = noteDao.getAll()
        Log.i("MyLOGg", notes.toString())
    }
}