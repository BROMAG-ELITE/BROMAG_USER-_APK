package com.example.bromagindia.ui.takeaway

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bromagindia.Interface.UpdateList
import com.example.bromagindia.R
import com.example.bromagindia.menu.MenuList
import com.example.bromagindia.subcusine.SubCusineGridList

class TakeawayMenuListActivity : AppCompatActivity(), UpdateList {

    private var categoryRecyclerView: RecyclerView? = null
    private  var subcategoryRecyclerView: RecyclerView? = null
    private var categoryAdapter: TakeawaySubCatAdapter? = null
    private var subcategoryAdapter: TakeawayMenuListAdapter? = null

    var items: java.util.ArrayList<MenuList> = java.util.ArrayList<MenuList>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_takeaway_menu_list)

        val menuListSearchView = findViewById<androidx.appcompat.widget.SearchView>(R.id.menuListSearchView)

        menuListSearchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                subcategoryAdapter?.filter?.filter(newText)
                return true
            }
        })

        categoryRecyclerView = findViewById(R.id.categoryRecyclerView)
        subcategoryRecyclerView = findViewById(R.id.subcategoryRecyclerView)
        subcategoryRecyclerView?.layoutManager = LinearLayoutManager(this)

        categoryRecyclerView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        subcategoryRecyclerView?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val item = ArrayList<SubCusineGridList?>()
        item.add(SubCusineGridList(R.drawable.vegetarian,"Vegetarian"))
        item.add(SubCusineGridList(R.drawable.egg,"Egg"))
        item.add(SubCusineGridList(R.drawable.chicken,"Chicken"))
        item.add(SubCusineGridList(R.drawable.mutton,"Mutton"))
        item.add(SubCusineGridList(R.drawable.seafood,"Sea Foods"))

        categoryAdapter = TakeawaySubCatAdapter(item, this)
        categoryRecyclerView?.adapter = categoryAdapter

        items = ArrayList()
        subcategoryAdapter = TakeawayMenuListAdapter(items)

        /* items.add(DynamicModal("qwert"))
         items.add(DynamicModal("oiuygt"))
         items.add(DynamicModal("qwert"))
         items.add(DynamicModal("cfvgbhn"))
         items.add(DynamicModal("wertyuiolkmnbhgf"))
         items.add(DynamicModal("mnhbgfgh"))
         items.add(DynamicModal("wsedrftg"))
         items.add(DynamicModal("qwert"))

         subcategoryAdapter = DynamicAdapter(this, items)
         subcategoryRecyclerView?.adapter = subcategoryAdapter*/

        /*
                subcategoryAdapter?.setLoadMore(object : LoadMore {
                    override fun onLoadMore() {
                        if (items.size <= 10) {
                            item.add(null)
                            subcategoryAdapter?.notifyItemInserted(items.size - 1)
                            Handler().postDelayed({
                                items.removeAt(items.size - 1)
                                subcategoryAdapter?.notifyItemRemoved(items.size)
                                val index = items.size
                                val end = index + 10
                                for (i in index until end) {
                                    val name = UUID.randomUUID().toString()
                                    val item = DynamicModal(name)
                                    items.add(item)
                                }
                                subcategoryAdapter?.notifyDataSetChanged()
                                subcategoryAdapter?.setLoaded()
                            }, 4000)
                        } else Toast.makeText(this@MainActivity, "No more data", Toast.LENGTH_SHORT).show()
                    }
                })
        */
    }


    override fun callback(position: Int, items: ArrayList<MenuList>) {
        subcategoryAdapter = TakeawayMenuListAdapter(items)
        subcategoryAdapter!!.notifyDataSetChanged()
        subcategoryRecyclerView!!.adapter = subcategoryAdapter
    }
}