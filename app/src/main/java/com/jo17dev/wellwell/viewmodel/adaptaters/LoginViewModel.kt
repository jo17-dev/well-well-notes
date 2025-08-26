package com.jo17dev.wellwell.viewmodel.adaptaters

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlin.math.log

// view model of login page
class LoginViewModel(application: Application) : AndroidViewModel(application) {
    public fun auth(
        login:String,
        password:String,
        onSuccess: () -> Unit,
        onFailed: (String) -> Unit ){
        if(login == "admin@gmail.com" && password == "yesorno"){
            onSuccess()
        }else{
            onFailed("Bruh.. wtf you tryna do ??")
        }
    }
}