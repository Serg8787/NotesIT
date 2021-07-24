package com.example.notesit


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey
    var id:Int,
    var title:String,
    var description:String?,
    var date: String,
    var isImpotent:Boolean ) {

}
