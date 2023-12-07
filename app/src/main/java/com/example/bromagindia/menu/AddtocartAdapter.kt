package com.example.bromagindia.menu

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bromagindia.ApplicationMain
import com.example.bromagindia.Interface.UpdateSelectedItem
import com.example.bromagindia.R

/*
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bromagindia.R
import java.util.ArrayList

class AddtocartAdapter(val context: AddtocartActivity, var menuLists : ArrayList<AddtocartList>) : RecyclerView.Adapter<AddtocartAdapter.ViewHolder>(){

    var pQuantity = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_items, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = menuLists[position]

        holder.quantity.text=dataItem.qty

        holder.plus.setOnClickListener {
            pQuantity = holder.quantity.text.toString().toInt()
            if (pQuantity >= 0) {
                var total_item: Int = holder.quantity.text.toString().toInt()
                total_item++
                holder.quantity.text = total_item.toString()
            }
            dataItem.qty=holder.quantity.text.toString()
        }

        holder.minus.setOnClickListener {
            pQuantity = holder.quantity.text.toString().toInt()
            if (pQuantity != 0) {
                var total_item: Int = holder.quantity.text.toString().toInt()
                total_item--
                holder.quantity.text = total_item.toString()
            }
            dataItem.qty=holder.quantity.text.toString()
        }

        Glide.with(context).load(dataItem.image).into(holder.img)
        holder.name.text=dataItem.name
        holder.price.text=dataItem.price

    }

    override fun getItemCount(): Int {
        return menuLists.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val plus = itemView.findViewById<Button>(R.id.btn_plus)
        val quantity = itemView.findViewById<TextView>(R.id.tv_quantity)
        val minus = itemView.findViewById<Button>(R.id.btn_minus)

        val img = itemView.findViewById<ImageView>(R.id.menuImage)
        val name = itemView.findViewById<TextView>(R.id.name)
        val price = itemView.findViewById<TextView>(R.id.price)

        fun bindItems(menuLists: AddtocartList, context: AddtocartActivity) {

        }
    }
}
*/


class AddtocartAdapter(var activity: Activity) :
    RecyclerView.Adapter<AddtocartAdapter.CartViewHolder>() {
    private var cartListModals: ArrayList<AddtocartList>? = (ApplicationMain.myContext as UpdateSelectedItem).items

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var price: TextView

        init {
            name = itemView.findViewById<TextView>(R.id.name)
            price = itemView.findViewById<TextView>(R.id.price)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.cart_items, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val currentItem: AddtocartList = cartListModals!![position]
        holder.name.text = currentItem.name
        holder.price.text=currentItem.price
    }

    override fun getItemCount(): Int {
        return cartListModals!!.size
    }
}
