package com.example.bromagindia.ui.dining

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.bromagindia.R
import com.example.bromagindia.databinding.FragmentDiningBinding
import com.example.bromagindia.subcusine.SubCusineActivity
import com.example.bromagindia.ui.home.TableActivity
import com.example.bromagindia.ui.takeaway.TakeawayGridAdapter
import com.example.bromagindia.ui.takeaway.TakeawayGridList

class DinigFragment : Fragment() {

    var adapter: DiningGridAdapter?=null
    var gridView: GridView?=null
    var checkin: TextView?=null
    var checkout: TextView?=null
    var cancel: TextView?=null
    var text:TextView?=null
    var bookedCard:CardView?=null
    var reservedText:TextView?=null
    var bookTableText:TextView?=null
    var bookTable:Button?=null


    var reservedImg:ImageView?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val root = inflater.inflate(R.layout.fragment_dining, container, false)


        bookedCard = root.findViewById(R.id.tableCardView)
        gridView = root.findViewById(R.id.Dingrid)
        checkin = root.findViewById(R.id.btn_checkin)
        checkout = root.findViewById(R.id.btn_checkout)
        cancel = root.findViewById(R.id.btn_cancel)
        text = root.findViewById(R.id.txtDinCusine)
        reservedText = root.findViewById(R.id.checkinText)
        bookTableText = root.findViewById(R.id.bookTableText)
        reservedImg = root.findViewById(R.id.reservedImage)
        bookTable = root.findViewById(R.id.bookTable)


        checkin?.setOnClickListener {
            checkin?.visibility=View.GONE
            cancel?.visibility=View.GONE
            checkout?.visibility=View.VISIBLE
            text?.visibility=View.VISIBLE
            gridView?.visibility=View.VISIBLE
            reservedImg?.visibility=View.GONE
            reservedText?.visibility=View.GONE
        }

        cancel?.setOnClickListener {
            bookedCard?.visibility=View.GONE
            reservedImg?.visibility=View.VISIBLE
            reservedText?.visibility=View.GONE
            bookTableText?.visibility=View.VISIBLE
            bookTable?.visibility=View.VISIBLE

        }

        bookTable?.setOnClickListener {
            val intent = Intent(context, TableActivity::class.java)
            context?.startActivity(intent)
        }

        val m = ArrayList<DiningGridList>()
        m.add(DiningGridList(R.drawable.indian,"Indian"))
        m.add(DiningGridList(R.drawable.arabian,"Arabian"))
        m.add(DiningGridList(R.drawable.mexican,"Mexican"))
        m.add(DiningGridList(R.drawable.american,"American"))
        m.add(DiningGridList(R.drawable.italian,"Italian"))
        m.add(DiningGridList(R.drawable.chinese,"Chinese"))
        m.add(DiningGridList(R.drawable.continental,"Continental"))
        m.add(DiningGridList(R.drawable.friedchicken,"Fried Chicken"))
        m.add(DiningGridList(R.drawable.dess,"Desserts & Beverages"))


        // on below line we are setting adapter to our grid view.

        adapter = DiningGridAdapter(this, m)
        gridView?.adapter = adapter

        gridView!!.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val intent = Intent(context, DiningMenuListActivity::class.java)
                context?.startActivity(intent)
            }

        return root

    }


}