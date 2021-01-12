package com.example.practice.Bdata

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.R
import com.example.practice.TaleActivity

import java.util.*
import kotlin.collections.ArrayList


class Adapter(val books : ArrayList<BookVO>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {              // View를 띄워주는 부분
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.book, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {  // ArrayList에 담겨있는 각 데이터를 바인드
        val Book = books[position]

        holder.img.setImageResource(Book.book_img)
        holder.text.text = Book.book_title
        holder.img.setOnClickListener(View.OnClickListener { v ->

            val intent = Intent(v.context, TaleActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("title", Book.book_title)
            context.startActivity(intent)
        })
    }

    override fun getItemCount(): Int {     // 목록 개수를 return
        return books.size

    }



}