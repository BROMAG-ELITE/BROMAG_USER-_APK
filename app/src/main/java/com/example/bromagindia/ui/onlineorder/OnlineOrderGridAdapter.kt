package com.example.bromagindia.ui.onlineorder

import android.annotation.SuppressLint
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.bromagindia.R


class OnlineOrderGridAdapter(val context: OnlineOrderFragment, private var iconList: ArrayList<OnlineOrderGridList>) : BaseAdapter() {

    override fun getCount(): Int {
        return iconList.size
    }

    override fun getItem(position: Int): Any {
        return iconList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val iList = this.iconList[position]

        val inflater = context.layoutInflater

        val view = inflater.inflate(R.layout.grid_items,parent,false)
        val icon = view.findViewById<ImageView>(R.id.icon)
        val name = view.findViewById<TextView>(R.id.name)


        Glide.with(context).load(iList.imageIcon).into(icon)
        name.text=iList.name

//        icon.setOnClickListener {
//            val intent= Intent(context, SubCusineActivity::class.java)
//            context.startActivity(intent)
//        }

        return view
    }
}
