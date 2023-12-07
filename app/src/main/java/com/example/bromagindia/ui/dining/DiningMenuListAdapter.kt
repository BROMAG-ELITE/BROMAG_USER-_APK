package com.example.bromagindia.ui.dining

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bromagindia.R
import com.example.bromagindia.menu.MenuActivity
import com.example.bromagindia.menu.MenuList
import java.util.Locale

internal class DiningMenuListAdapter(var dynamicModals: ArrayList<MenuList>) :
    RecyclerView.Adapter<DiningMenuListAdapter.DynamicHolder>(), Filterable {

    var newList :ArrayList<MenuList> = dynamicModals

    inner class DynamicHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img = itemView.findViewById<ImageView>(R.id.menuImage)
        val name = itemView.findViewById<TextView>(R.id.name)
        val add = itemView.findViewById<Button>(R.id.btnAdd)
        val price = itemView.findViewById<TextView>(R.id.price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DynamicHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_items, parent, false)
        return DynamicHolder(view)
    }

    override fun onBindViewHolder(holder: DynamicHolder, position: Int) {
        val currentItem = newList[position]
        holder.img.setImageResource(currentItem.image)
        holder.name.text=currentItem.name
        holder.price.text=currentItem.price
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {

            override fun performFiltering(constraint: CharSequence): FilterResults {

                val queryString = constraint.toString().lowercase(Locale.ROOT)

                val filterResults = FilterResults()
                filterResults.values = if ( queryString.isEmpty())
                    dynamicModals
                else
                    dynamicModals.filter {
                        it.name.lowercase(Locale.ROOT).contains(queryString)
                    }
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {

                newList = results!!.values as ArrayList<MenuList>
                notifyDataSetChanged()
            }

        }
    }
}


