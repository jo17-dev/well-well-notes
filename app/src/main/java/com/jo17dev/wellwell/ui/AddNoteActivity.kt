package com.jo17dev.wellwell.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jo17dev.wellwell.R
import com.jo17dev.wellwell.model.database.AppDatabase
import com.jo17dev.wellwell.model.entities.NoteEntity
import com.jo17dev.wellwell.model.entities.NoteStatus

class AddNoteActivity : AppCompatActivity() {

    private lateinit var btnCancel: Button
    private  lateinit var btnValidate: Button
    private  lateinit var etTitle: EditText
    private  lateinit var etDescription: EditText
    private  lateinit var tvTitle: TextView

    private val pageTitle = "Well Well... "
    private val pageSubTitle = "Add a note"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_note)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // adding btn
        btnCancel = findViewById(R.id.btn_cancel_edit)
        btnValidate = findViewById(R.id.btn_validate_edit)
        etTitle = findViewById(R.id.et_title)
        etDescription = findViewById(R.id.et_description)
        tvTitle = findViewById(R.id.tv_activity_title)


        tvTitle.text = pageTitle + pageSubTitle

        btnValidate.setOnClickListener() {

            val titleString = etTitle.text.toString()
            val descriptionString = etDescription.text.toString()

            if(!validateForm(titleString, descriptionString)){
                Toast.makeText(this, "The entered datas are not valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //every this passed validation here..
            val db = AppDatabase.getInstance(application)

            Log.d("ADD_NOTE_UI", "Test de la fonctionn jahah")
            Log.d("ADD_NOTE_UI", db.toString())
            //Log.d("ADD_NOTE_UI", db.toString())
            db.noteDao().add(NoteEntity(title = titleString, description = descriptionString, status = NoteStatus.TODO))

            // making toast
            Toast.makeText(this, "The note has been Added", Toast.LENGTH_SHORT).show()
        }


        btnCancel.setOnClickListener() {
            startActivity(Intent(this, NotesListActivity::class.java))
        }
    }



    private fun validateForm (title:String, description:String):Boolean {
        return title.isNotEmpty()
    }
}