package com.example.rxjavawithretrofit.model

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi{

    @GET("users")
    fun getUsers():Single<UsersResponse>

    @GET("users")
    suspend fun getUsers2(): UsersResponse


    companion object {
        operator fun invoke(): MyApi {
            return Retrofit.Builder()
                .baseUrl("https://apolis-property-management.herokuapp.com/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}