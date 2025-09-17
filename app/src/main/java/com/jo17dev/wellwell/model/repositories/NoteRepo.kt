package com.jo17dev.wellwell.model.repositories

import com.jo17dev.wellwell.model.dao.NoteDao
import com.jo17dev.wellwell.model.entities.Note

class NoteRepo(private val noteDao: NoteDao) {
    suspend fun addNote(note: Note): Long {
        return noteDao.add(note)
    }

    suspend fun getAll(): ArrayList<Note> {
        val noteEntities = noteDao.getAll()

        val notes: ArrayList<Note> = ArrayList<Note>()

        noteEntities.forEach {
            notes.add(
                Note(id = it.id, title=it.title, description = it.description, status = it.status)
            )
        }
        return notes
    }

    suspend fun findById(id:Long): Note?{
        return noteDao.findById(id)
    }
}