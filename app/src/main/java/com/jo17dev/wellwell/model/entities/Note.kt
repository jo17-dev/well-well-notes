package com.jo17dev.wellwell.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String?,
    val status: NoteStatus = NoteStatus.TODO
)