package com.example.bromagindia.menu

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bromagindia.Interface.UpdateSelectedItem
import com.example.bromagindia.R

/*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bromagindia.R

class AddtocartActivity : AppCompatActivity() {

    var adapter: AddtocartAdapter?=null
    var rv: RecyclerView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtocart)

        rv = findViewById(R.id.addtocartRecyclerview)
        rv?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


        val m = ArrayList<AddtocartList>()
        m.add(AddtocartList(R.drawable.vegetarian,"Dish 1","120","0"))
        m.add(AddtocartList(R.drawable.vegetarian,"Dish 2","50","0"))
        m.add(AddtocartList(R.drawable.vegetarian,"Dish 3","78","0"))
        m.add(AddtocartList(R.drawable.vegetarian,"Dish 3","220","0"))


        adapter = AddtocartAdapter(this, m)
        rv?.adapter = adapter
    }
}*/


class AddtocartActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var cartAdapter: AddtocartAdapter? = null
    var context: Activity? = null
    var updateSelectedItem: UpdateSelectedItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addtocart)
        recyclerView = findViewById(R.id.addtocartRecyclerview)
        recyclerView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        cartAdapter = AddtocartAdapter(context!!)
        recyclerView?.adapter = cartAdapter
    }
}