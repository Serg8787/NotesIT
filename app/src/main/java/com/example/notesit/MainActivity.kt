package com.example.notesit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ViewHolder.ItemCallback {
//    lateinit var notesList:ArrayList<Note>
    lateinit var adapter: NoteAdapter
    lateinit var noteDatabase:AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        noteDatabase = AppDatabase.getDatabase(this)
//        notesList = noteDatabase.noteDao().getAll() as ArrayList<Note>

//        notesList.add(Note(1,"Сходить в магазин","Картошка, помидор, огурец, холодной воды, мороженое","07,07,07",false))
//        adapter = NoteAdapter(this,notesList,this)
//        recycler.layoutManager = LinearLayoutManager(this)
//        recycler.adapter = adapter




//     DatabaseThread(this)
    }

    override fun deleteItem(index: Int) {
        Thread(Runnable {
            //some method her

            noteDatabase.noteDao().deleteNote()
        }).start()

    }

    override fun editItem(index: Int) {
        TODO("Not yet implemented")
    }

    override fun impotentItem(index: Int) {
        TODO("Not yet implemented")
    }
}