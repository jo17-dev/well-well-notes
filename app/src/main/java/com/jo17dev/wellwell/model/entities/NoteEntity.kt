package com.jo17dev.wellwell.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jo17dev.wellwell.model.entities.NoteStatus


@Entity(tableName = "notes")
data class NoteEntity (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String?,
    val status: NoteStatus = NoteStatus.TODO
)