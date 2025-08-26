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
import androidx.lifecycle.lifecycleScope
import com.jo17dev.wellwell.R
import com.jo17dev.wellwell.model.database.AppDatabase
import com.jo17dev.wellwell.model.entities.Note
import com.jo17dev.wellwell.model.repositories.NoteRepo
import com.jo17dev.wellwell.viewmodel.adaptaters.LoginViewModel
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var btnLogin: Button
    private lateinit var etEmail : EditText
    private lateinit var etPassword: EditText

    private lateinit var loginVM: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // parsing variables:
        btnLogin  = findViewById(R.id.btn_login)
        etEmail = findViewById(R.id.et_email)
        etPassword = findViewById(R.id.et_password)

        loginVM = LoginViewModel(application)

        // lien vers la liste de notes
        btnLogin.setOnClickListener({

            loginVM.auth(
                etEmail.text.toString(),
                etPassword.text.toString(),

                onSuccess = fun (){
                    startActivity(Intent(this, NotesListActivity::class.java))
                },

                onFailed =  fun (reason:String){
                    Toast.makeText(this, "Bruh.. $reason", Toast.LENGTH_SHORT).show()
                }
            )


            if(etEmail.text.toString() == "admin@gmail.com" && etPassword.text.toString() == "admin"){
                startActivity(Intent(this, NotesListActivity::class.java))
            }else{
                Toast.makeText(this, "Credentials not valid.. Try again.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}