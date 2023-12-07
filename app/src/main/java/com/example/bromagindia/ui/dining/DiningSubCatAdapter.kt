package com.example.bromagindia.ui.dining

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bromagindia.Interface.UpdateList
import com.example.bromagindia.R
import com.example.bromagindia.menu.MenuList
import com.example.bromagindia.subcusine.SubCusineGridList

class DiningSubCatAdapter(private val items: java.util.ArrayList<SubCusineGridList?>, updateList: DiningMenuListActivity) : RecyclerView.Adapter<DiningSubCatAdapter.StaticViewHolder>() {
    var rowindex = -1
    var updateList: UpdateList
    var check = true
    var select = true

    init {
        this.updateList = updateList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StaticViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.subcusine_grid_items, parent, false)
        return StaticViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: StaticViewHolder,
        position: Int
    ) {
        val currentItem = items[position]
        holder.textView.text = currentItem?.name
        currentItem?.imageIcon?.let { holder.imageView.setImageResource(it) }
        if (check) {
            val items = ArrayList<MenuList>()
            items.add(MenuList(R.drawable.vegetarian,"Idly","120"))
            items.add(MenuList(R.drawable.vegetarian,"Dosa","50"))
            items.add(MenuList(R.drawable.vegetarian,"Pongal","78"))
            items.add(MenuList(R.drawable.vegetarian,"Chilli Idly","100"))
            items.add(MenuList(R.drawable.vegetarian,"Podi Dosa","40"))
            items.add(MenuList(R.drawable.vegetarian,"Veg Briyani","10"))
            items.add(MenuList(R.drawable.vegetarian,"Parotta","220"))
            items.add(MenuList(R.drawable.vegetarian,"Rita","56"))

            updateList.callback(position, items)
            check = false
        }
        holder.linearLayout.setOnClickListener {
            rowindex = position
            notifyDataSetChanged()
            if (position == 0) {
                val items = ArrayList<MenuList>()
                items.add(MenuList(R.drawable.vegetarian,"Idly","120"))
                items.add(MenuList(R.drawable.vegetarian,"Dosa","50"))
                items.add(MenuList(R.drawable.vegetarian,"Pongal","78"))
                items.add(MenuList(R.drawable.vegetarian,"Chilli Idly","100"))
                items.add(MenuList(R.drawable.vegetarian,"Podi Dosa","40"))
                items.add(MenuList(R.drawable.vegetarian,"Veg Briyani","10"))
                items.add(MenuList(R.drawable.vegetarian,"Parotta","220"))
                items.add(MenuList(R.drawable.vegetarian,"Rita","56"))
                updateList.callback(position, items)
            } else if (position == 1) {
                val items = ArrayList<MenuList>()
                items.add(MenuList(R.drawable.egg,"Egg Gravy","120"))
                items.add(MenuList(R.drawable.egg,"Omlet","50"))
                items.add(MenuList(R.drawable.egg,"Egg Dish","78"))
                items.add(MenuList(R.drawable.egg,"Podimas","100"))
                updateList.callback(position, items)
            } else if (position == 2) {
                val items = ArrayList<MenuList>()
                items.add(MenuList(R.drawable.chicken,"Chilli Chicken","120"))
                items.add(MenuList(R.drawable.chicken,"Briyani","50"))
                items.add(MenuList(R.drawable.chicken,"Chicken 65","78"))
                items.add(MenuList(R.drawable.chicken,"Lollipop","100"))
                items.add(MenuList(R.drawable.chicken,"Garlic Chicken","40"))
                updateList.callback(position, items)
            }
            else if (position == 3) {
                val items = ArrayList<MenuList>()
                items.add(MenuList(R.drawable.mutton,"Mutton Gravy","120"))
                items.add(MenuList(R.drawable.mutton,"Sukka","50"))
                items.add(MenuList(R.drawable.mutton,"Soup","78"))
                items.add(MenuList(R.drawable.mutton,"Briyani","100"))
                items.add(MenuList(R.drawable.mutton,"Kimma","40"))
                items.add(MenuList(R.drawable.mutton,"Mutton Podimas","10"))
                items.add(MenuList(R.drawable.mutton,"Cutlet","220"))
                updateList.callback(position, items)
            }
            else if (position == 4) {
                val items = ArrayList<MenuList>()
                items.add(MenuList(R.drawable.seafood,"Fish Briyani","120"))
                items.add(MenuList(R.drawable.seafood,"Prawn Biriyani","50"))
                items.add(MenuList(R.drawable.seafood,"Fish Fry","78"))
                items.add(MenuList(R.drawable.seafood,"Squid","100"))
                items.add(MenuList(R.drawable.seafood,"Prawn","40"))
                updateList.callback(position, items)
            }
        }
        if (select) {
            if (position == 0) holder.linearLayout.setBackgroundResource(R.drawable.sub_sel)
            select = false
        } else {
            if (rowindex == position) {
                holder.linearLayout.setBackgroundResource(R.drawable.sub_sel)
            } else {
                holder.linearLayout.setBackgroundResource(R.drawable.sub_bg)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class StaticViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView
        var imageView: ImageView
        var linearLayout: LinearLayout

        init {
            imageView = itemView.findViewById(R.id.icon)
            textView = itemView.findViewById(R.id.name)
            linearLayout = itemView.findViewById(R.id.lay1)
        }
    }
}

