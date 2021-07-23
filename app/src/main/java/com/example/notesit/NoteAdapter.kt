package com.example.notesit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_item.view.*

class NoteAdapter(val context: Context, val noteList: ArrayList<Note>) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.note_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pos = holder.getAdapterPosition()
        holder.tittle.text = noteList[pos].title
        holder.description.text = noteList[pos].description
        holder.date.text = noteList[pos].date
    }

    override fun getItemCount() = noteList.size
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var tittle: TextView
    var description: TextView
    var date: TextView
    var editItem: ImageView
    var deleteItem: ImageView
    var impotentItem: ImageView


    init {
        tittle = itemView.tvTitleItem
        description = itemView.tvDescriptionItem
        date = itemView.tvDateItem
        editItem = itemView.ivEditItem
        deleteItem = itemView.iDeleteItem
        impotentItem = itemView.ivImpotentItem

    }
}