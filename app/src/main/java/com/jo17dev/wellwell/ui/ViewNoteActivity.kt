package com.jo17dev.wellwell.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jo17dev.wellwell.R

class ViewNoteActivity : AppCompatActivity() {
    private lateinit var btnBack: Button
    private lateinit var btnEdit: Button

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


        btnBack.setOnClickListener {
            startActivity(
                Intent(applicationContext, NotesListActivity::class.java)
            )
        }

    }
}