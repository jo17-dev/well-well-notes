package com.jo17dev.wellwell.common
// this will be used to communication status between viewmodels and activuties
enum class ResponseCode(val code: Int, val message: String) {
    // general responses
    FAILED(99, "Operaion Failed"),
    SUCCESS(100, "Operation succeeded"),
    CREATED(102, "Creation suceeded"),
    UPDATED(103, "successfully updated"),
    DELETED(104, "successfully deleted"),


    // specific responses goes here...
    LOADING(1024, "Loading datas"),
}
