package com.example.notesit

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewHolder.ItemCallback {
    lateinit var adapter: NoteAdapter
    lateinit var noteDatabase: AppDatabase
    lateinit var notesList: ArrayList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        notesList = ArrayList<Note>()
        noteDatabase = AppDatabase.getDatabase(this)
        getData()
        adapter = NoteAdapter(this, notesList, this)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter


        floatingActionButton.setOnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }

    override fun deleteItem(index: Int) {
        val note = notesList.get(index)
        noteDatabase.noteDao().deleteNote(note)
        getData()
        adapter.notifyDataSetChanged()

    }

    override fun editItem(index: Int) {
        val inflter = LayoutInflater.from(this)
        val v = inflter.inflate(R.layout.update_note, null)
        val title = v.findViewById<EditText>(R.id.etTitleUpdate)
        val description = v.findViewById<EditText>(R.id.etDescriptionUpdate)

        val addDialog = AlertDialog.Builder(this)
        addDialog
            .setView(v)
            .setPositiveButton("Ok") { dialog, _ ->
                val note = notesList.get(index)
                note.title = title.text.toString()
                note.description = description.text.toString()
                noteDatabase.noteDao().updateNote(note)
                getData()
                adapter.notifyDataSetChanged()
                Toast.makeText(this, "User Information is Edited", Toast.LENGTH_SHORT).show()
                dialog.dismiss()

            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()


    }

    @SuppressLint("ResourceAsColor")
    override fun impotentItem(index: Int) {


    }

    fun getData() {
        val noteFromDb: List<Note> = noteDatabase.noteDao().getAll()
        notesList.clear()
        notesList.addAll(noteFromDb)
    }
}