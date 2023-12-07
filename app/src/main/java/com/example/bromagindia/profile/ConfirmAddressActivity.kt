package com.example.bromagindia.profile

import android.graphics.Color
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.bromagindia.R

class ConfirmAddressActivity : AppCompatActivity() {
    var enterAddress: Button?=null
    var addLay1:LinearLayout?=null
    var addLay2:LinearLayout?=null

    var btnStatus=1
    var btn1: TextView?=null
    var btn2: TextView?=null
    var btn3: TextView?=null
    var category:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_address)

        enterAddress=findViewById(R.id.btnCompleteAddress)
        addLay1 = findViewById(R.id.completeAddressLay)
        addLay2 = findViewById(R.id.saveAddressLay)


        enterAddress?.setOnClickListener {
            addLay1?.visibility = View.GONE
            addLay2?.visibility = View.VISIBLE
        }

        btn1=findViewById(R.id.home)
        btn2=findViewById(R.id.work)
        btn3=findViewById(R.id.others)

        btn1?.setOnClickListener {
            category="Home"
            if (btnStatus==1)
            {
                btn1?.setBackgroundResource(R.drawable.add_active)
                btn2?.setBackgroundResource(R.drawable.add_grey)
                btn3?.setBackgroundResource(R.drawable.add_grey)

//                btn1?.setTextColor(Color.WHITE)
//                btn2?.setTextColor(Color.parseColor("#8A8A8A"))
//                btn3?.setTextColor(Color.parseColor("#8A8A8A"))

            }
            else{
                btn1?.setBackgroundResource(R.drawable.add_grey)
//                btn1?.setTextColor(Color.parseColor("#8A8A8A"))
            }
        }
        btn2?.setOnClickListener {
            category="Work"
            if (btnStatus==1)
            {
                btn2?.setBackgroundResource(R.drawable.add_active)
                btn1?.setBackgroundResource(R.drawable.add_grey)
                btn3?.setBackgroundResource(R.drawable.add_grey)

//                btn2?.setTextColor(Color.WHITE)
//                btn1?.setTextColor(Color.parseColor("#8A8A8A"))
//                btn3?.setTextColor(Color.parseColor("#8A8A8A"))

            }
            else{
                btn2?.setBackgroundResource(R.drawable.add_grey)
//                btn2?.setTextColor(Color.parseColor("#8A8A8A"))
            }
        }
        btn3?.setOnClickListener {
            category="Others"
            if (btnStatus==1)
            {
                btn3?.setBackgroundResource(R.drawable.add_active)
                btn1?.setBackgroundResource(R.drawable.add_grey)
                btn2?.setBackgroundResource(R.drawable.add_grey)

//                btn3?.setTextColor(Color.WHITE)
//                btn1?.setTextColor(Color.parseColor("#8A8A8A"))
//                btn2?.setTextColor(Color.parseColor("#8A8A8A"))

            }
            else{
                btn3?.setBackgroundResource(R.drawable.add_grey)
//                btn3?.setTextColor(Color.parseColor("#8A8A8A"))
            }
        }

    }
}