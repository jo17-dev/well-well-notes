package com.jo17dev.wellwell.viewmodel.adaptaters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jo17dev.wellwell.R
import com.jo17dev.wellwell.model.entities.Note

class NoteListAdptater(private var notes: ArrayList<Note>) : RecyclerView.Adapter<NoteListAdptater.ViewHolder>()  {


    // ceci est le view Holder qu'on déclaire, qu'on es en fait censé déclarer avant l'adaptater
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle : TextView
        val itemSwitch: Switch

        init {
            itemTitle = view.findViewById(R.id.tv_note_title)
            itemSwitch = view.findViewById(R.id.s_note_status)
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
//        holder.itemSwitch.
        // holder.setIsRecyclable(true)
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}