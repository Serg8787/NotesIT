package com.example.notesit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_note.*
import java.text.SimpleDateFormat
import java.util.*

class AddNoteActivity : AppCompatActivity() {
    lateinit var noteDatabase:AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        noteDatabase = AppDatabase.getDatabase(this)


        btSave.setOnClickListener {
            val title:String = etTittle.text.toString()
            val description:String = etDescription.text.toString()
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm")
            val currentDate = sdf.format(Date())
            val date:String = currentDate
            val note:Note = Note(title = title,description = description,date = date,isImpotent = false)
            noteDatabase.noteDao().insertNote(note)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}