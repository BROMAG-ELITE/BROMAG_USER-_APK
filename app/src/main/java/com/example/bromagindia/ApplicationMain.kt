package com.example.bromagindia

import android.app.Application
import android.content.Context
import com.example.bromagindia.Interface.UpdateSelectedItem
import com.example.bromagindia.menu.AddtocartList

class ApplicationMain : Application(), UpdateSelectedItem {
    var cartListModals: ArrayList<AddtocartList>? = null
    override fun onCreate() {
        super.onCreate()
        myContext = applicationContext
        cartListModals = ArrayList<AddtocartList>()
    }

    override fun addItems(
        img: Int,
        name: String, price: String
        , qty: String
    ) {
        cartListModals!!.add(AddtocartList(
            img,
            name, price
            ,qty
        ))
    }


    override val items: ArrayList<AddtocartList>?
        get() = cartListModals

    companion object {
        var myContext: Context? = null
            private set
    }
}
