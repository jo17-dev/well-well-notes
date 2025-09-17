package com.jo17dev.wellwell.viewmodel.adaptaters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jo17dev.wellwell.R
import com.jo17dev.wellwell.model.entities.Note
import com.jo17dev.wellwell.model.entities.NoteStatus
import com.jo17dev.wellwell.ui.ViewNoteActivity

class NoteListAdptater(private var notes: ArrayList<Note>) : RecyclerView.Adapter<NoteListAdptater.ViewHolder>()  {


    // ceci est le view Holder qu'on déclaire, qu'on es en fait censé déclarer avant l'adaptater
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle : TextView
        val itemSwitch: Switch

        var noteId: Long? = null;


        init {
            itemTitle = view.findViewById(R.id.tv_note_title)
            itemSwitch = view.findViewById(R.id.s_note_status)
            itemTitle.setOnClickListener {
                val intent = Intent(view.context, ViewNoteActivity::class.java).apply {
                    putExtra("noteId", noteId)
                }
                view.context.startActivity(intent)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    public fun updateList(newList: ArrayList<Note>){
        // notes = newList;
        notes.clear()
        notes.addAll(newList)
        notifyDataSetChanged()
    }

    // à Evenement d'ajout'un nouveau ViewHolder. mais n'ajoute pas les données !
    // ici on fait juste créer la vu vide
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val createdView:View = LayoutInflater.from((parent.context))
            .inflate(R.layout.note_item_view, parent, false)
        return  ViewHolder(createdView)
    }

    // seed les données de la ViewHolder avec de les données de la liste ( les vrais datas)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = notes[position].title
        holder.itemSwitch.isChecked = (notes[position].status == NoteStatus.DONE)
        holder.noteId = notes[position].id

        holder.itemTitle.text = notes[position].title
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}