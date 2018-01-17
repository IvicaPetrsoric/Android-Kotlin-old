package com.example.ivica.listview

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.row_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)
        val redColor = Color.parseColor("#FFFFFF")
        listView.setBackgroundColor(redColor)

        // this need to be my custom adapter telling my list what to render
        listView.adapter = MyCustomAdapter(this)
    }

    private class MyCustomAdapter(context: Context): BaseAdapter(){

        private val mContext: Context
        private val name = arrayListOf<String>(
                "Donald Trump", "Steve Jobs", "Tim Cook", "Ivica",
                "Donald Trump", "Steve Jobs", "Tim Cook", "Ivica",
                "Donald Trump", "Steve Jobs", "Tim Cook", "Ivica",
                "Donald Trump", "Steve Jobs", "Tim Cook", "Ivica",
                "Donald Trump", "Steve Jobs", "Tim Cook", "Ivica",
                "Donald Trump", "Steve Jobs", "Tim Cook", "Ivica"
        )

        init {
            this.mContext = context
//            System.out.println("MyCustomAdapter")
        }
        // how many rows in my list
        override fun getCount(): Int{
            return name.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getItem(position: Int): Any {
            return "Test STRING"
        }

        // responsible for rendering out each row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

            // implementing viewHolder
            val rowMain: View

            if (convertView == null){
                val layoutInflater = LayoutInflater.from(viewGroup!!.context)
                rowMain = layoutInflater.inflate(R.layout.row_main, viewGroup,false)

//                val textView = rowMain.name_textView
//                val pTextView = rowMain.position_textView
//                val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
//                val positionTextView = rowMain.findViewById<TextView>(R.id.position_textView)

//                val viewHolder = ViewHolder(nameTextView, positionTextView)
                val viewHolder = ViewHolder(rowMain.name_textView, rowMain.position_textView)

                rowMain.tag = viewHolder
            }else{
                rowMain = convertView
            }

            Log.v("getView", "calling getView")

//            val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
//            nameTextView.text = name.get(position)

            val viewHolder = rowMain.tag as ViewHolder
            viewHolder.nameTextView.text = name.get(position)

//            val positionTextView = rowMain.findViewById<TextView>(R.id.position_textView)
//            positionTextView.text = "Row number: $position"
            viewHolder.positionTextView.text = "Row number: $position"

            return rowMain

//            val textView = TextView(mContext)
//            textView.text = "Here is my row"
//            return textView
        }

        private class ViewHolder(val nameTextView: TextView, val positionTextView: TextView){

        }


    }
}
