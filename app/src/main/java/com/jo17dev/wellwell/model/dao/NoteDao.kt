package com.jo17dev.wellwell.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.google.android.material.circularreveal.CircularRevealHelper.Strategy
import com.jo17dev.wellwell.model.entities.Note


@Dao
interface NoteDao {
    @Query("SELECT * from notes")
    suspend fun getAll(): List<Note>

    @Query("SELECT * from notes where id = :id")
    suspend fun findById(id:Long): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(note: Note): Long

    @Update
    suspend fun update(note: Note)
}