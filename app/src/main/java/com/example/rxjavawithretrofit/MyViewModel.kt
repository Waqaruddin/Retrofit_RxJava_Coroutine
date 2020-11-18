package com.example.rxjavawithretrofit

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers


class MyViewModel :ViewModel(){

    fun getUsers():LiveData<UsersResponse>{

        //Log.d("vm", userResponse.toString())

        return MyRespository().getUsers()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    val firstUser = liveData(Dispatchers.IO){
        val response = MyRespository().getUsers2()
        emit(response)
    }

}