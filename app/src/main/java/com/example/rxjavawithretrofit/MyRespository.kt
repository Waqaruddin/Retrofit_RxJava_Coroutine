package com.example.rxjavawithretrofit

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyRespository{
    fun getUsers(): LiveData<UsersResponse>{

        var users = MutableLiveData<UsersResponse>()

        MyApi().getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<UsersResponse>(){
                override fun onSuccess(t: UsersResponse) {
                    Log.d("abc", t.data[0].name)
                    users.value = t
                }

                override fun onError(e: Throwable) {
                    Log.d("abc", e.message!!)
                }

            })

        return users
    }



    suspend fun getUsers2() = MyApi().getUsers2()



}