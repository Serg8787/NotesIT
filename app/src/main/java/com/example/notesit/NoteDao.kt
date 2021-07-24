package com.example.notesit


import androidx.room.*

@Dao
interface NoteDao {
    @Query("SELECT * FROM Note")
    fun getAll(): List<Note>

    @Insert
    fun insertNote(note:Note)

    @Delete
    fun deleteNote(note: Note)

    @Update
    fun updateNote(note: Note)


    @Query("SELECT * FROM note WHERE id = :id")
    fun getNoteById(id: Int): Note?

}