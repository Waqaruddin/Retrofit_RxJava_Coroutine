package com.example.rxjavawithretrofit

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.rxjavawithretrofit.model.MyRespository
import com.example.rxjavawithretrofit.model.Users
import kotlinx.coroutines.Dispatchers


class MyViewModel :ViewModel(){

    fun getUsers():LiveData<ArrayList<Users>>{

        //Log.d("vm", userResponse.toString())

        return MyRespository().getUsers()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    val firstUser = liveData(Dispatchers.IO){
        val response = MyRespository().getUsers2()
        emit(response)
    }

}