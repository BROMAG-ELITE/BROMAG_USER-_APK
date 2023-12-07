package com.example.bromagindia.Interface

import com.example.bromagindia.menu.MenuList

interface UpdateList {
    fun callback(position: Int, items: ArrayList<MenuList>)
}
