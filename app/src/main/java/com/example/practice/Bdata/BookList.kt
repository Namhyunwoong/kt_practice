package com.example.practice.Bdata

import com.example.practice.R

class BookList {

    var books = ArrayList<BookVO>()

    fun addBook(): ArrayList<BookVO> {

        books.add(BookVO(R.drawable.cindy, "신데렐라"))
        books.add(BookVO(R.drawable.hensel, "헨젤과 그레텔"))
        books.add(BookVO(R.drawable.match, "성냥팔이 소녀"))
        books.add(BookVO(R.drawable.boots, "장화신은 고양이"))
        books.add(BookVO(R.drawable.snow, "백설공주"))

        return books

    }
}