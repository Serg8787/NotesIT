package com.example.notesit

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.note_item.view.*

class NoteAdapter(
    val context: Context,
    val noteList: List<Note>,
    val callback: ViewHolder.ItemCallback
) :
    RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.note_item, parent, false))
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note: Note = noteList[position]
        val pos = holder.getAdapterPosition()

        holder.tittle.text = noteList[pos].title
        holder.description.text = noteList[pos].description
        holder.date.text = noteList[pos].date
        holder.deleteItem.setOnClickListener {
            callback.deleteItem(pos)
        }
        holder.editItem.setOnClickListener {
            callback.editItem(pos)
        }
        val colorId:Int
        if (noteList[pos].isImpotent.equals(1)) {
           colorId = holder.itemView.resources.getColor(R.color.red)
        } else {
           colorId = holder.itemView.resources.getColor(R.color.grey)
        }
        holder.tittle.setBackgroundColor(colorId)
        }
        override fun getItemCount() = noteList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var tittle: TextView
        var description: TextView
        var date: TextView
        var editItem: ImageView
        var deleteItem: ImageView
//        var impotentItem: ImageView
        var constRoot: View


        init {
            tittle = itemView.tvTitleItem
            description = itemView.tvDescriptionItem
            date = itemView.tvDateItem
            editItem = itemView.ivEditItem
            deleteItem = itemView.ivDeleteItem
//            impotentItem = itemView.ivImpotentItem
            constRoot = itemView.constRoot
        }

        interface ItemCallback {
            fun deleteItem(index: Int)
            fun editItem(index: Int)
            fun impotentItem(index: Int)
        }

    }