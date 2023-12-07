package com.example.bromagindia.ui.onlineorder

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bromagindia.Interface.UpdateList
import com.example.bromagindia.Interface.UpdateSelectedItem
import com.example.bromagindia.R
import com.example.bromagindia.menu.AddtocartActivity
import com.example.bromagindia.menu.AddtocartList
import com.example.bromagindia.menu.MenuList
import com.example.bromagindia.subcusine.SubCusineGridList

class MenuListActivity : AppCompatActivity(), UpdateList {

    private var categoryRecyclerView: RecyclerView? = null
    private  var subcategoryRecyclerView: RecyclerView? = null
    private var categoryAdapter: SubCatAdapter? = null
    private var subcategoryAdapter: MenuListAdapter? = null

    var items: java.util.ArrayList<MenuList> = java.util.ArrayList<MenuList>()
    var updateSelectedItem: UpdateSelectedItem? = null
    var context: Context? = null
    var cart: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_list)

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

        categoryAdapter = SubCatAdapter(item, this)
        categoryRecyclerView?.adapter = categoryAdapter

        //        subcategoryAdapter = new DynamicAdapter(items);
        cart = findViewById<ImageView>(R.id.cart)
        cart?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AddtocartActivity::class.java)
            startActivity(intent)
        })

        items = ArrayList()
//        subcategoryAdapter = MenuListAdapter(items)

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
        subcategoryAdapter = MenuListAdapter(items
            //,
            //updateSelectedItem!!
//            ,context!!,updateSelectedItem!!
        )
        subcategoryAdapter!!.notifyDataSetChanged()
        subcategoryRecyclerView!!.adapter = subcategoryAdapter
    }
}