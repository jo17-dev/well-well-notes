package com.jo17dev.wellwell.viewmodel.adaptaters

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import kotlin.math.log

// view model of login page
class LoginViewModel() : ViewModel() {
    public fun auth(
        login:String,
        password:String,
        onSuccess: () -> Unit,
        onFailed: (String) -> Unit ){
//        if(login == "admin@gmail.com" && password == "admin"){
//            onSuccess()
//        }else{
//            onFailed("Bruh.. wtf you tryna do ??")
//        }

        // on vas bypasser le loggin ici dabord::
        onSuccess();
    }
}