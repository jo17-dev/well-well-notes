package com.jo17dev.wellwell.model.entities

import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class Note(var title:String,  var status:NoteStatus=NoteStatus.TODO, var description:String?) {
    @OptIn(ExperimentalUuidApi::class)
    private val id:String = Uuid.random().toString()

    override fun toString(): String {
        return "note # $id - titre: $title - description:  $description} "
    }
}