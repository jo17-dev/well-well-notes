package com.jo17dev.wellwell.model.entities

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class Note(private var title:String, private var status:NoteStatus=NoteStatus.TODO, private var description:String?) {
    @OptIn(ExperimentalUuidApi::class)
    private val id:String = Uuid.random().toString()
}