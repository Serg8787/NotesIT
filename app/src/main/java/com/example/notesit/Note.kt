package com.example.notesit


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Note(
    @PrimaryKey
    val id:Int,
    val title:String?,
    val description:String?,
    val date:String?,
    val isImpotent:Boolean )