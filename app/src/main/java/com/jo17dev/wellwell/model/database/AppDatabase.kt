package com.jo17dev.wellwell.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jo17dev.wellwell.model.dao.NoteDao
import com.jo17dev.wellwell.model.entities.NoteEntity


@Database(entities = [NoteEntity::class], version = 1)
abstract  class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        @Volatile // cross process stuff
        private var INSTANCE: AppDatabase?= null


        fun getInstance(context: Context): AppDatabase {
            return  INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "well_well_note_db")
                    .build().also { INSTANCE = it}
            }
        }
    }
}