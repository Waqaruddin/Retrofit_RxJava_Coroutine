package com.example.rxjavawithretrofit.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MyRespository{
    fun getUsers(): LiveData<ArrayList<Users>>{

        var users = MutableLiveData<ArrayList<Users>>()

        MyApi().getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<UsersResponse>(){
                override fun onSuccess(t: UsersResponse) {
                    Log.d("abc", t.data[0].name)
                    users.value = t.data
                }

                override fun onError(e: Throwable) {
                    Log.d("abc", e.message!!)
                }

            })

        return users
    }



    suspend fun getUsers2() = MyApi().getUsers2()



}