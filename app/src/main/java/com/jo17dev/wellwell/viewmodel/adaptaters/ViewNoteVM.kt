package com.jo17dev.wellwell.viewmodel.adaptaters

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jo17dev.wellwell.model.database.AppDatabase
import com.jo17dev.wellwell.model.entities.Note
import com.jo17dev.wellwell.model.repositories.NoteRepo
import kotlinx.coroutines.launch

class ViewNoteVM(application: Application) : AndroidViewModel(application) {

    private val _db : AppDatabase by lazy { AppDatabase.getInstance(application) }
    private val _noteRepository by lazy { NoteRepo(_db.noteDao()) }
    private val _note: Note? = null
    private var isLoading = MutableLiveData<Boolean>(false)
    public var note: MutableLiveData<Note?> =  MutableLiveData<Note?>(null)
    fun loadNote(noteId: Long){

        Log.d("VIEW_NOTE_ACTIVITY", "loading note... ")
        viewModelScope.launch() {
            isLoading.value = true
            val retrievedDatas = _noteRepository.findById(noteId)
            note.value = retrievedDatas
            isLoading.value = false

            Log.d("VIEW_NOTE_ACTIVITY", "Note LOadED $retrievedDatas ")
        }
    }

}