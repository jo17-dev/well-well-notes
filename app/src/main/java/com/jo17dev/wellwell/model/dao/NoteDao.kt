package com.jo17dev.wellwell.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.jo17dev.wellwell.model.entities.NoteEntity


@Dao
interface NoteDao {
    @Query("SELECT * from notes")
    fun getAll(): List<NoteEntity>

    @Query("SELECT * from notes where id = :id")
    fun findById(id:Long): NoteEntity

    @Insert
    fun add(note: NoteEntity)

    @Update
    fun update(note: NoteEntity)
}