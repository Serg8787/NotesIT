package com.example.notesit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewHolder.ItemCallback {
    lateinit var adapter: NoteAdapter
    lateinit var noteDatabase:AppDatabase
    lateinit var notesList:ArrayList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notesList = ArrayList<Note>()

        noteDatabase = AppDatabase.getDatabase(this)
        getData()
//        notesList = noteDatabase.noteDao().getAll()
        adapter = NoteAdapter(this,notesList,this)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter


        floatingActionButton.setOnClickListener {
               val intent = Intent(this,AddNoteActivity::class.java)
            startActivity(intent)
        }

    }

    override fun deleteItem(index: Int) {
        val note = notesList.get(index)
        if (note != null) {
            noteDatabase.noteDao().deleteNote(note)
            getData()
            adapter.notifyDataSetChanged()
        }
        Toast.makeText(this,"Удаление"+index,Toast.LENGTH_LONG).show()

    }

    override fun editItem(index: Int) {


    }

    override fun impotentItem(index: Int) {

    }
    fun getData(){
        val noteFromDb:List<Note> = noteDatabase.noteDao().getAll()
        notesList.clear()
        notesList.addAll(noteFromDb)

    }
}