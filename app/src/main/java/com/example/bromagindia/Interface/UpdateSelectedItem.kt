package com.example.bromagindia.Interface

import com.example.bromagindia.menu.AddtocartList

interface UpdateSelectedItem {
    fun addItems(
        img:Int,
        name: String, price: String
        , qty:String
    )
    val items: ArrayList<AddtocartList>?
}
