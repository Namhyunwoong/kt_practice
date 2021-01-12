package com.example.practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.Bdata.Adapter
import com.example.practice.Bdata.BookList
import com.example.practice.Bdata.BookVO
import kotlinx.android.synthetic.main.activity_fairytale.*

class FairytaleActivity : AppCompatActivity() {

    var books = ArrayList<BookVO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fairytale)

        val book = BookList()
        books = book.addBook()

        rv_tale.layoutManager = LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        rv_tale.adapter = Adapter(books, this)


    }
}

