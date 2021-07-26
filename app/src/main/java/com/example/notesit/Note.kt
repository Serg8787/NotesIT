package com.example.notesit



import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Note(
//    @PrimaryKey(autoGenerate = true)
//
//    var id: Int,
    var title: String,
    var description: String?,
    var date: String,
    var isImpotent: Int,

){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
