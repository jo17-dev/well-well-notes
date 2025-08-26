package com.jo17dev.wellwell.model.repositories

import com.jo17dev.wellwell.model.dao.NoteDao
import com.jo17dev.wellwell.model.entities.Note
import com.jo17dev.wellwell.model.entities.NoteEntity

class NoteRepo(private val noteDao: NoteDao) {
    suspend fun addNote(note: NoteEntity): Long {
        return noteDao.add(note)
    }

    suspend fun getAll(): ArrayList<Note> {
        val noteEntities = noteDao.getAll()

        val notes: ArrayList<Note> = ArrayList<Note>()

        noteEntities.forEach {
            notes.add(
                Note(it.title, description = it.description, status = it.status)
            )
        }
        return notes
    }

}