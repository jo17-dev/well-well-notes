package com.jo17dev.wellwell.model.repositories

import com.jo17dev.wellwell.model.dao.NoteDao
import com.jo17dev.wellwell.model.entities.NoteEntity

class NoteRepo(private val noteDao: NoteDao) {
    suspend fun addNote(note: NoteEntity): Long {
        return noteDao.add(note)
    }

}