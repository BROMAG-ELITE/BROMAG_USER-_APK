package com.example.bromagindia.profile

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.example.bromagindia.R

class FeedbackActivity : AppCompatActivity() {

    var back: LinearLayout?=null
    var btnStatus=1
    var btn1: Button?=null
    var btn2: Button?=null
    var btn3: Button?=null
    var btn4: Button?=null
    var category:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        btn1=findViewById(R.id.btnCat1)
        btn2=findViewById(R.id.btnCat2)
        btn3=findViewById(R.id.btnCat3)
        btn4=findViewById(R.id.btnCat4)

        back=findViewById(R.id.backFeedback)
        back?.setOnClickListener {

            this.onBackPressed()
        }

        btn1?.setOnClickListener {
            category="Suggestion"
            if (btnStatus==1)
            {
                btn1?.setBackgroundResource(R.drawable.button_selected)
                btn2?.setBackgroundResource(R.drawable.button_deselected)
                btn3?.setBackgroundResource(R.drawable.button_deselected)
                btn4?.setBackgroundResource(R.drawable.button_deselected)

                btn1?.setTextColor(Color.WHITE)
                btn2?.setTextColor(Color.parseColor("#8A8A8A"))
                btn3?.setTextColor(Color.parseColor("#8A8A8A"))
                btn4?.setTextColor(Color.parseColor("#8A8A8A"))

                //  btnStatus=0
            }
            else{
                btn1?.setBackgroundResource(R.drawable.button_deselected)
                btn1?.setTextColor(Color.parseColor("#8A8A8A"))
                //  btnStatus=1
            }
        }
        btn2?.setOnClickListener {
            category="Complaint"
            if (btnStatus==1)
            {
                btn2?.setBackgroundResource(R.drawable.button_selected)
                btn1?.setBackgroundResource(R.drawable.button_deselected)
                btn3?.setBackgroundResource(R.drawable.button_deselected)
                btn4?.setBackgroundResource(R.drawable.button_deselected)

                btn2?.setTextColor(Color.WHITE)
                btn1?.setTextColor(Color.parseColor("#8A8A8A"))
                btn3?.setTextColor(Color.parseColor("#8A8A8A"))
                btn4?.setTextColor(Color.parseColor("#8A8A8A"))

                //  btnStatus=0
            }
            else{
                btn2?.setBackgroundResource(R.drawable.button_deselected)
                btn2?.setTextColor(Color.parseColor("#8A8A8A"))
                // btnStatus=1
            }
        }
        btn3?.setOnClickListener {
            category="App Experience"
            if (btnStatus==1)
            {
                btn3?.setBackgroundResource(R.drawable.button_selected)
                btn1?.setBackgroundResource(R.drawable.button_deselected)
                btn2?.setBackgroundResource(R.drawable.button_deselected)
                btn4?.setBackgroundResource(R.drawable.button_deselected)

                btn3?.setTextColor(Color.WHITE)
                btn1?.setTextColor(Color.parseColor("#8A8A8A"))
                btn2?.setTextColor(Color.parseColor("#8A8A8A"))
                btn4?.setTextColor(Color.parseColor("#8A8A8A"))

                //  btnStatus=0
            }
            else{
                btn3?.setBackgroundResource(R.drawable.button_deselected)
                btn3?.setTextColor(Color.parseColor("#8A8A8A"))
                //  btnStatus=1
            }
        }
        btn4?.setOnClickListener {
            category="Need Help"
            if (btnStatus==1)
            {
                btn4?.setBackgroundResource(R.drawable.button_selected)
                btn1?.setBackgroundResource(R.drawable.button_deselected)
                btn2?.setBackgroundResource(R.drawable.button_deselected)
                btn3?.setBackgroundResource(R.drawable.button_deselected)

                btn4?.setTextColor(Color.WHITE)
                btn1?.setTextColor(Color.parseColor("#8A8A8A"))
                btn2?.setTextColor(Color.parseColor("#8A8A8A"))
                btn3?.setTextColor(Color.parseColor("#8A8A8A"))

                //   btnStatus=0
            }
            else{
                btn4?.setBackgroundResource(R.drawable.button_deselected)
                btn4?.setTextColor(Color.parseColor("#8A8A8A"))
                //  btnStatus=1
            }
        }

    }
}