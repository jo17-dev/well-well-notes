package com.jo17dev.wellwell.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jo17dev.wellwell.R
import com.jo17dev.wellwell.model.entities.Note
import com.jo17dev.wellwell.model.entities.NoteStatus
import com.jo17dev.wellwell.viewmodels.adaptaters.NoteListAdptater

class NotesListActivity : AppCompatActivity() {
    // actual list of notes
    private var notes: ArrayList<Note> = ArrayList<Note>()

    private lateinit var noteList: RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_notes_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // seeding notes::

        for (i in 1..7){
            notes.add( Note("Titre de la note $i", NoteStatus.TODO, "description de la note"))
        }


        // binding all the datas from the xml

        noteList = findViewById(R.id.rv_note_list)
        noteList.layoutManager = LinearLayoutManager(this)
        noteList.adapter = NoteListAdptater(notes)

    }


}