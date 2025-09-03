package com.jo17dev.wellwell.viewmodel.adaptaters

import android.app.Application
import android.os.SystemClock.sleep
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.jo17dev.wellwell.model.database.AppDatabase
import com.jo17dev.wellwell.model.entities.Note
import com.jo17dev.wellwell.model.entities.NoteStatus
import com.jo17dev.wellwell.model.repositories.NoteRepo
import kotlinx.coroutines.launch

class NoteListVM(application: Application) : AndroidViewModel(application) {

    private val _db: AppDatabase by lazy { AppDatabase.getInstance(application) }
    private val _noteRepository by lazy { NoteRepo(_db.noteDao()) }
    public val noteList: MutableLiveData<ArrayList<Note>> = MutableLiveData(ArrayList<Note>())

    // loading state
    public var isLoading = MutableLiveData<Boolean>(false);

    init {
        isLoading.value = true;
        // launch la req vers la BD en async
        viewModelScope.launch {
            noteList.value =  _noteRepository.getAll();
            isLoading.value = false;
        }
    }

    fun loadNotes(){
        isLoading.value = true;
        // launch la req vers la BD en async
        viewModelScope.launch {
            noteList.value =  _noteRepository.getAll();
            isLoading.value = false;
        }
    }
}