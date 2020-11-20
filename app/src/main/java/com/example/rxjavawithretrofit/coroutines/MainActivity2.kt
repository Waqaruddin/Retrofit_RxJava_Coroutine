package com.example.rxjavawithretrofit.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxjavawithretrofit.MyViewModel
import com.example.rxjavawithretrofit.R
import com.example.rxjavawithretrofit.model.Users
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    private val model: MyViewModel by viewModels()

    private var mList: ArrayList<Users> = ArrayList()
    private var adapter2: UsersAdapter2? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        init()
    }

    private fun init() {
        adapter2 = UsersAdapter2(this, mList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter2

        model.firstUser.observe(this, {

            adapter2?.setData(it.data)
        })
    }
}