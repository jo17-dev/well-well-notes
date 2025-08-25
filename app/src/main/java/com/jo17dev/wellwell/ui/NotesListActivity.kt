package com.jo17dev.wellwell.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jo17dev.wellwell.R
import com.jo17dev.wellwell.model.entities.Note
import com.jo17dev.wellwell.model.entities.NoteStatus
import com.jo17dev.wellwell.viewmodel.adaptaters.NoteListAdptater

class NotesListActivity : AppCompatActivity() {
    // actual list of notes
    private var notes: ArrayList<Note> = ArrayList<Note>()

    private lateinit var noteList: RecyclerView;
    private lateinit var btn_AddNote: Button;
    private lateinit var et_noteTitle: EditText;

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

        for (i in 1..5){
            notes.add( Note("Titre de laswswqdw qdwqd wqddqdq dqdwqd dadada fewuwef note $i", NoteStatus.TODO, "description de la note"))
        }


        // binding all the datas from the xml

        noteList = findViewById(R.id.rv_note_list)
        noteList.layoutManager = LinearLayoutManager(this)
        noteList.adapter = NoteListAdptater(notes)

        btn_AddNote = findViewById(R.id.btn_add_note)
        et_noteTitle = findViewById(R.id.et_note_title)


        // au click, pour ajouter une note sans description/alarm
        btn_AddNote.setOnClickListener{

            if(et_noteTitle.text.toString() == ""){
                Toast.makeText(this, "note ${et_noteTitle.text} ", Toast.LENGTH_SHORT).show()
            }else{
                notes.add(Note(et_noteTitle.text.toString(), NoteStatus.TODO, "No description given"))
                Toast.makeText(this, "You note has been added ", Toast.LENGTH_SHORT).show()
                noteList.adapter = NoteListAdptater(notes)
            }
        }

        btn_AddNote.setOnLongClickListener {
            startActivity(Intent(this, AddNoteActivity::class.java))
            true
        }
    }


}