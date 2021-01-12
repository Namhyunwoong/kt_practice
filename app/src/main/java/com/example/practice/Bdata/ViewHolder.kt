package com.example.practice.Bdata

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.book.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val img = itemView.horizon_icon!!
    val text = itemView.horizon_description!!

}