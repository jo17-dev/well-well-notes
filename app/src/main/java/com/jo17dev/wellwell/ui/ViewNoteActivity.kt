package com.jo17dev.wellwell.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.jo17dev.wellwell.R
import com.jo17dev.wellwell.model.database.AppDatabase
import com.jo17dev.wellwell.model.entities.Note
import kotlinx.coroutines.launch

class ViewNoteActivity : AppCompatActivity() {
    private lateinit var btnBack: Button
    private lateinit var btnEdit: Button
    private lateinit var tvNoteTitle: TextView
    private lateinit var tvNoteDescription: TextView

    private val db by lazy { AppDatabase.getInstance(applicationContext) }
    private val noteRepository by lazy { db.noteDao() }

    private var note: Note? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_note)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.view_note_page)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnBack = findViewById<Button>(R.id.btn_back)
        tvNoteTitle = findViewById<TextView>(R.id.tv_note_title)
        tvNoteDescription = findViewById<TextView>(R.id.tv_note_description)



        lifecycleScope.launch {
            val noteId:Long = intent.getLongExtra("noteId", 0)
            tvNoteTitle.text = "La note est::" + noteId.toString()

            note = noteRepository.findById(noteId)
            // tvNoteTitle.text = note?.title
            tvNoteDescription.text = note?.description
        }



        btnBack.setOnClickListener {
            startActivity(
                Intent(applicationContext, NotesListActivity::class.java)
            )
        }

    }
}