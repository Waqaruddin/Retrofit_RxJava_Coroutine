package com.example.rxjavawithretrofit.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxjavawithretrofit.MyViewModel
import com.example.rxjavawithretrofit.R
import com.example.rxjavawithretrofit.model.Users
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var adapter: UsersAdapter? = null
    private val mList: ArrayList<Users> = ArrayList()
    private val model: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()


    }

    private fun init() {
        adapter = UsersAdapter(this, mList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = adapter

        model.getUsers().observe(this, {
            adapter?.setData(it)
        })

    }
}