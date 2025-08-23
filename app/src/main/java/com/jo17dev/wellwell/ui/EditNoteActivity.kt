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
import com.jo17dev.wellwell.R

class EditNoteActivity : AppCompatActivity() {

    private lateinit var btnCancel: Button
    private  lateinit var btnValidate: Button
    private  lateinit var etTitle: EditText
    private  lateinit var etDescription: EditText

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


        btnValidate.setOnClickListener() {
            if(!validateForm(etTitle.text.toString(), etDescription.text.toString())){
                Toast.makeText(this, "The entered datas are not valid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //every this passed validation here..
            Toast.makeText(this, "The note has been edited/added", Toast.LENGTH_SHORT).show()


        }


        btnCancel.setOnClickListener() {
            startActivity(Intent(this, NotesListActivity::class.java))
        }
    }



    private fun validateForm (title:String, description:String):Boolean {
        return title.isNotEmpty()
    }
}